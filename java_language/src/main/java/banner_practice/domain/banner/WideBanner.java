package banner_practice.domain.banner;

import banner_practice.domain.Image;
import banner_practice.domain.RichText;
import lombok.Getter;

@Getter
public class WideBanner extends Banner {
    private final RichText subDescription;
    public WideBanner(Image image, RichText mainDescription, RichText subDescription, boolean adultOnly) {
        super(image, mainDescription, adultOnly);
        this.subDescription = subDescription;
    }
}
