package banner_practice.service;

import banner_practice.domain.BannerContainer;
import banner_practice.repository.BannerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BannerServiceTest {

    BannerService SUT = new BannerService(new BannerRepository());
    ObjectMapper objectMapper = new ObjectMapper();
    File actual;
    File expected;

    @AfterEach
    public void cleanUpEach(){
        actual.delete();
    }

    @Test
    public void test() throws IOException {
        // given
        // when
        BannerContainer bannerContainer = SUT.getBanner();

        // then
        actual = new File("src/test/resources/actual/wideCarouselBannerContainerResult.json");
        expected  = new File("src/test/resources/expected/wideCarouselBannerContainerResult.json");
        objectMapper.writeValue(actual, bannerContainer);
        assertEquals(objectMapper.readTree(actual), objectMapper.readTree(expected));
    }

}