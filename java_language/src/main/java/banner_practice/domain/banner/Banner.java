package banner_practice.domain.banner;

import banner_practice.domain.Image;
import banner_practice.domain.RichText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Banner {
    private final Image image;
    private final RichText mainDescription;
    private final boolean adultOnly;
}
