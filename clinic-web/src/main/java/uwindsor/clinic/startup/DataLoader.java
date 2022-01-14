package uwindsor.clinic.startup;

import com.uwindsor.clinic.models.*;
import com.uwindsor.clinic.services.OwnerService;
import com.uwindsor.clinic.services.PetTypeService;
import com.uwindsor.clinic.services.SpecialityService;
import com.uwindsor.clinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
// make this as the spring bean and this will execute
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }



    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){

        }

        loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = (PetType) petTypeService.save(dog); // I can reuse this data
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = (PetType) petTypeService.save(cat);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialityService.save(dentistry);


        Owner o1 = new Owner();
        o1.setFirstName("James");
        o1.setLastName("Dickson");
        o1.setAddress("111 Bickering street");
        o1.setCity("New York");
        o1.setTelephone("12312313");

        Pet jamesPet = new Pet();
        jamesPet.setPetType(savedDog);
        jamesPet.setOwners(o1);
        jamesPet.setBirthDate(LocalDate.now());
        jamesPet.setName("Doug");
        o1.getPets().add(jamesPet);


        ownerService.save(o1);


        Owner o2 = new Owner();

        o2.setFirstName("Camelon");
        o2.setLastName("Pierce");
        o2.setAddress("111 mahamthm street");
        o2.setCity("Las Vegas");
        o2.setTelephone("323232");


        Pet camelonPet = new Pet();
        camelonPet.setPetType(savedCat);
        camelonPet.setOwners(o2);
        camelonPet.setBirthDate(LocalDate.now());
        camelonPet.setName("Fox");
        o2.getPets().add(camelonPet);


        ownerService.save(o2);

        System.out.println("find l2:" +ownerService.findById(2L));


        System.out.println("loaded owners");

        System.out.println(ownerService.findAll());
        Vet v1 = new Vet();

        v1.setFirstName("Cruseor");
        v1.setLastName("Robinson");
        v1.getSpecialties().add(savedRadiology);

        vetService.save(v1);
        Vet v2 = new Vet();

        v2.setFirstName("Mark");
        v2.setLastName("Twin");
        v2.getSpecialties().add(savedDentistry);
        vetService.save(v2);
        System.out.println("loaded vets....");
    }
}
