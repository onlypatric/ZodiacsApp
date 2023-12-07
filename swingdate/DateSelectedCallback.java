package swingdate;
import java.time.LocalDate;

public interface DateSelectedCallback {
    void onDateSelected(LocalDate selectedDate);
    
}
