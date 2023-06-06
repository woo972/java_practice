package banner_practice.service.factory;

import banner_practice.domain.banner.Banner;
import banner_practice.repository.BannerEntity;
import java.util.List;

public abstract class BannerFactory {
    public abstract List<Banner> createBanners(BannerEntity bannerEntity);
}
