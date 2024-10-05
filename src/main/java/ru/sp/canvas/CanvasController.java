package ru.sp.canvas;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CanvasController {

    private final List<CanvasMessage> shapesCache = new ArrayList<>();

    @MessageMapping("/draw")
    @SendTo("/topic/canvas")
    public List<CanvasMessage> send(CanvasMessage message) {
        message.setId(UUID.randomUUID().toString());
        shapesCache.add(message);
        return shapesCache;
    }

    @MessageMapping("/redraw")
    @SendTo("/topic/canvas")
    public List<CanvasMessage> redraw() {
        return shapesCache;
    }

    @MessageMapping("/move")
    @SendTo("/topic/canvas")
    public List<CanvasMessage> move(CanvasMessage message) {
        for (CanvasMessage shape : shapesCache) {
            if (shape.getId().equals(message.getId())) {
                shape.setX(message.getX());
                shape.setY(message.getY());
                shape.setX2(message.getX2());
                shape.setY2(message.getY2());
                break;
            }
        }
        return shapesCache;
    }

    @MessageMapping("/delete")
    @SendTo("/topic/canvas")
    public List<CanvasMessage> delete(CanvasMessage message) {
        shapesCache.removeIf(shape -> shape.getId().equals(message.getId()));
        return shapesCache;
    }

    @MessageMapping("/clear")
    @SendTo("/topic/canvas")
    public List<CanvasMessage> clear() {
        shapesCache.clear();
        return shapesCache;
    }
}