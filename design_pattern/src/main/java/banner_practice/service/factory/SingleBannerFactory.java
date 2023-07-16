package banner_practice.service.factory;

import banner_practice.domain.Image;
import banner_practice.domain.PreDefinedStyle;
import banner_practice.domain.RichText;
import banner_practice.domain.banner.Banner;
import banner_practice.domain.banner.SingleBanner;
import banner_practice.repository.BannerEntity;
import java.util.List;

public class SingleBannerFactory extends BannerFactory {
    @Override
    public List<Banner> createBanners(BannerEntity bannerEntity) {
        Image image = new Image(bannerEntity.getImagePaths().get(0), null);
        RichText mainDescription = new RichText(bannerEntity.getTexts().get(0), false, PreDefinedStyle.Size.MEDIUM);
        return List.of(new SingleBanner(image, mainDescription, bannerEntity.getAdultOnlyProperties().get(0)));
    }
}
