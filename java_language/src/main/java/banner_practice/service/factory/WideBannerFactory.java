package banner_practice.service.factory;

import banner_practice.domain.Image;
import banner_practice.domain.PreDefinedStyle;
import banner_practice.domain.RichText;
import banner_practice.domain.banner.Banner;
import banner_practice.domain.banner.WideBanner;
import banner_practice.repository.BannerEntity;
import java.util.List;

public class WideBannerFactory extends BannerFactory{
    public List<Banner> createBanners(BannerEntity bannerEntity) {
        Image image = new Image(bannerEntity.getImagePaths().get(0), bannerEntity.getLandingPageLinks().get(0));
        RichText mainDescription = new RichText(bannerEntity.getTexts().get(0), true, PreDefinedStyle.Size.LARGE);
        RichText subDescription = new RichText(bannerEntity.getTexts().get(0), true, PreDefinedStyle.Size.SMALL);
        return List.of(new WideBanner(image, mainDescription, subDescription, bannerEntity.getAdultOnlyProperties().get(0)));
    }
}
