package swingdate;
import java.time.LocalDateTime;

public interface DateTimeSelectedCallback {
    void onDateSelected(LocalDateTime selectedDate);
}
