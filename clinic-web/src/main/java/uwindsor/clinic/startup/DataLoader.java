package uwindsor.clinic.startup;

import com.uwindsor.clinic.models.Owner;
import com.uwindsor.clinic.models.Vet;
import com.uwindsor.clinic.models.map.OwnerServiceMap;
import com.uwindsor.clinic.models.map.VetServiceMap;
import com.uwindsor.clinic.services.OwnerService;
import com.uwindsor.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
// make this as the spring bean and this will execute
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    /*  public DataLoader(){
       // ownerService = new OwnerServiceMap();
       // vetService = new VetServiceMap();







    }

    */


    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("James");
        o1.setLastName("Dickson");

        ownerService.save(o1);


        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Camelon");
        o2.setLastName("Pierce");

        ownerService.save(o2);


        System.out.println("loaded owners");

        Vet v1 = new Vet();
        v1.setId(3L);
        v1.setFirstName("Cruseor");
        v1.setLastName("Robinson");

        vetService.save(v1);
        Vet v2 = new Vet();
        v2.setId(4L);
        v2.setFirstName("Mark");
        v2.setLastName("Twin");
        vetService.save(v2);
        System.out.println("loaded vets....");

    }
}
