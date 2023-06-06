package banner_practice.domain.banner;

import banner_practice.domain.Image;
import banner_practice.domain.RichText;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class WideCarouselBanner extends Banner {

    private final RichText subDescription;

    public WideCarouselBanner(Image images, RichText mainDescription, RichText subDescription, boolean adultOnly) {
        super(images, mainDescription, adultOnly);
        this.subDescription = subDescription;
    }

    public boolean isWideBanner(){
        return true;
    }
    public boolean isCarouselBanner(){
        return true;
    }
}
