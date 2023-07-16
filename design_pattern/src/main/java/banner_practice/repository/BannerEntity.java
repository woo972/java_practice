package banner_practice.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BannerEntity {
    private Long bannerId;
    private String bannerLayout;
    private List<String> imagePaths;
    private List<String> landingPageLinks;
    private List<String> texts;
    private List<String> subTexts;
    private List<Boolean> adultOnlyProperties;
}
