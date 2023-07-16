package banner_practice.service.factory;

import banner_practice.domain.Image;
import banner_practice.domain.PreDefinedStyle;
import banner_practice.domain.RichText;
import banner_practice.domain.banner.Banner;
import banner_practice.domain.banner.WideCarouselBanner;
import banner_practice.repository.BannerEntity;

import java.util.ArrayList;
import java.util.List;

public class WideCarouselBannerFactory extends BannerFactory{
    @Override
    public List<Banner> createBanners(BannerEntity bannerEntity) {
        int numberOfBanners = bannerEntity.getImagePaths().size();
        List<Banner> banners = new ArrayList<>();
        for (int index = 0; index < numberOfBanners; index++) {
            Image image = new Image(bannerEntity.getImagePaths().get(index), bannerEntity.getLandingPageLinks().get(index));
            RichText mainDescription = new RichText(bannerEntity.getTexts().get(index), true, PreDefinedStyle.Size.LARGE);
            RichText subDescription = new RichText(bannerEntity.getSubTexts().get(index), false, PreDefinedStyle.Size.SMALL);
            boolean adultOnly = bannerEntity.getAdultOnlyProperties().get(0);
            banners.add(new WideCarouselBanner(image, mainDescription, subDescription, adultOnly));
        }
        return banners;
    }
}
