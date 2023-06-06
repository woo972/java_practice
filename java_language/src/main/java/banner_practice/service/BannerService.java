package banner_practice.service;

import banner_practice.domain.BannerContainer;
import banner_practice.domain.banner.Banner;
import banner_practice.domain.banner.BannerLayout;
import banner_practice.repository.BannerRepository;
import banner_practice.repository.BannerEntity;
import banner_practice.service.factory.SingleBannerFactory;
import banner_practice.service.factory.WideBannerFactory;
import banner_practice.service.factory.BannerFactory;
import banner_practice.service.factory.WideCarouselBannerFactory;
import java.util.List;

public class BannerService {
    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public BannerContainer getBanner(){
        // banner 조회
        BannerEntity bannerEntity = bannerRepository.getBanner();

        // banner layout에 맞는 factory 생성
        BannerLayout bannerLayout = BannerLayout.valueOf(bannerEntity.getBannerLayout());
        BannerFactory factory = getBannerFactory(bannerLayout);
        List<Banner> banners = factory.createBanners(bannerEntity);

        // banner 노출 가능 여부 확인
        banners =filterAdultOnly(banners);

        // banner container 반환
        return new BannerContainer(bannerLayout, banners);
    }

    private BannerFactory getBannerFactory(BannerLayout bannerLayout){
        BannerFactory bannerFactory;
        if (bannerLayout.equals(BannerLayout.SINGLE)) {
            bannerFactory = new SingleBannerFactory();
        } else if (bannerLayout.equals(BannerLayout.WIDE_SINGLE)) {
            bannerFactory = new WideBannerFactory();
        } else if (bannerLayout.equals(BannerLayout.WIDE_CAROUSEL)) {
            bannerFactory = new WideCarouselBannerFactory();
        } else {
            bannerFactory = new SingleBannerFactory();
        }
        return bannerFactory;
    }

    private List<Banner> filterAdultOnly(List<Banner> banners) {
        return banners.stream()
                .filter(banner -> !banner.isAdultOnly())
                .toList();
    }

    private void visibleBannerEntity(List<Banner> banners) {

    }
}
