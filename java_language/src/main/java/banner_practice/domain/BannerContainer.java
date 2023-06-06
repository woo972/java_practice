package banner_practice.domain;

import banner_practice.domain.banner.Banner;
import banner_practice.domain.banner.BannerLayout;
import lombok.Getter;
import java.util.List;

@Getter
public class BannerContainer {
    private final BannerLayout bannerLayout;
    private final List<Banner> banners;

    public BannerContainer(BannerLayout bannerLayout, List<Banner> banners) {
        this.bannerLayout = bannerLayout;
        this.banners = banners;
    }
}
