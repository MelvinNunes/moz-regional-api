package com.melvinnunes.mozambique.infrastructure.integrations.gemini.dto;

import java.util.List;

public class GeminiRequest {
    private Contents contents;

    public GeminiRequest(String message) {
        this.contents = new Contents(message);
    }

    // Getters and setters
    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public static class Contents {
        private List<Part> parts;

        public Contents(String message) {
            this.parts = List.of(new Part(message));
        }

        // Getters and setters
        public List<Part> getParts() {
            return parts;
        }

        public void setParts(List<Part> parts) {
            this.parts = parts;
        }

        public static class Part {
            private String text;

            public Part(String text) {
                this.text = text;
            }

            // Getters and setters
            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
