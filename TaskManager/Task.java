import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String startDate;
    private String endDate;
    private String name;
    private String description;
    public boolean isComplete;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public Task(Integer id, String name, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = formatter.format(startDate);
        this.endDate = formatter.format(endDate);
        this.name = name;
        this.description = description;
        this.isComplete = false;
    }

    @Override
    public String toString() {
        String str = "Название: " + name +
                    "\nОписание: " + description +
                    "\nДата создания: " + startDate +
                    "\nДата окончания: " + endDate +
                    "\nВыполнена: ";
        str += isComplete ? "да" : "нет";            
        return str; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = formatter.format(startDate);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = formatter.format(endDate);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
