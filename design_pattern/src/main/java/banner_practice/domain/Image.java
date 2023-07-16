package banner_practice.domain;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Image {
    @NonNull
    private String imagePath;
    private String landingPageLink;

    public Image(String imagePath, String landingPageLink) {
        verifyImagePath(imagePath);
        verifyLandingPageLink(imagePath);
        this.imagePath = imagePath;
        this.landingPageLink = landingPageLink;
    }
    private void verifyImagePath(String imagePath) {
        // image path가 제대로 된 것인지 확인
        // null이면 nullpointerexception
    }
    private void verifyLandingPageLink(String imagePath) {
        // landingPageLink 형식 확인
        // null 이면 empty string으로 변환
    }
}
