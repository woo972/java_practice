package banner_practice.domain.banner;

import banner_practice.domain.Image;
import banner_practice.domain.RichText;
import lombok.Getter;

@Getter
public class SingleBanner extends Banner {
    public SingleBanner(Image image, RichText mainDescription, boolean adultOnly) {
        super(image, mainDescription, adultOnly);
    }
}
