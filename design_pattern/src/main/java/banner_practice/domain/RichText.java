package banner_practice.domain;

import lombok.Getter;

@Getter
public class RichText {
    private String text;
    private boolean bold;
    private PreDefinedStyle.Size size;

    public RichText(String text) {
        new RichText(text, false, PreDefinedStyle.Size.SMALL);
    }
    public RichText(String text, boolean bold, PreDefinedStyle.Size size) {
        this.text = text;
        this.bold = bold;
        this.size = size;
    }
}
