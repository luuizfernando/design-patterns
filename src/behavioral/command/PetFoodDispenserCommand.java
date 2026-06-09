package behavioral.command;

/**
 * Role: Concrete Command
 *
 * Dispenses a single serving of pet food.
 * This action is irreversible - undo does nothing.
 */
public class PetFoodDispenserCommand implements SmartHomeCommand {
    private PetFoodDispenser petFoodDispenser;

    public PetFoodDispenserCommand(PetFoodDispenser petFoodDispenser) {
        this.petFoodDispenser = petFoodDispenser;
    }

    @Override
    public void execute() {
        petFoodDispenser.dispense();
    }

    @Override
    public void undo() {
        System.out.println("[Command] Cannot undo: food already dispensed.");
    }

    @Override
    public String getDescription() {
        return "Dispense pet food serving";
    }
}