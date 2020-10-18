package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void gerBeerById() {
        BeerDto dto = client.gerBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
      // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

    }

    @Test
    void testUpdateBeer() {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testdeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

}