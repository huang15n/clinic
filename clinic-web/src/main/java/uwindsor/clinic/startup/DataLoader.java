package uwindsor.clinic.startup;

import com.uwindsor.clinic.models.Owner;
import com.uwindsor.clinic.models.Pet;
import com.uwindsor.clinic.models.PetType;
import com.uwindsor.clinic.models.Vet;
import com.uwindsor.clinic.services.OwnerService;
import com.uwindsor.clinic.services.PetTypeService;
import com.uwindsor.clinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
// make this as the spring bean and this will execute
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    /*  public DataLoader(){
       // ownerService = new OwnerServiceMap();
       // vetService = new VetServiceMap();







    }

    */


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = (PetType) petTypeService.save(dog); // I can reuse this data
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = (PetType) petTypeService.save(cat);



        Owner o1 = new Owner();
        o1.setFirstName("James");
        o1.setLastName("Dickson");


        ownerService.save(o1);


        Owner o2 = new Owner();

        o2.setFirstName("Camelon");
        o2.setLastName("Pierce");

        ownerService.save(o2);

        System.out.println("find l2:" +ownerService.findById(2L));




        System.out.println("loaded owners");

        System.out.println(ownerService.findAll());
        Vet v1 = new Vet();

        v1.setFirstName("Cruseor");
        v1.setLastName("Robinson");

        vetService.save(v1);
        Vet v2 = new Vet();

        v2.setFirstName("Mark");
        v2.setLastName("Twin");
        vetService.save(v2);
        System.out.println("loaded vets....");

    }
}
