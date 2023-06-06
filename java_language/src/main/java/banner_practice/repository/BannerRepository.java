package banner_practice.repository;

import java.util.List;

public class BannerRepository {
    public BannerEntity getBanner(){
        return new BannerEntity(
                0L,
                "WIDE_CAROUSEL",
                List.of("/cdn/image/banner/top/1", "/cdn/image/banner/top/2", "/cdn/image/banner/top/3"),
                List.of("/link/page1", "/link/page2", "/link/page3"),
                List.of("banner1","banner2","banner3"),
                List.of("sub1","sub2","sub3"),
                List.of(false, false, true)
        );
    }
}
