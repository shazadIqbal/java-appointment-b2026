import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientHistory {

    /*

    [
    {
        prescription : "ddwadawda",
        labTest : "dawdawdwad"
        bloodGroup: " dawdawdawda "
    },
    {
        remarks: "dwdwadwd "
    }



    ]

     */


   private List<Map<String,String>> recordList = new ArrayList<>();

    public List<Map<String, String>> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Map<String, String>> recordList) {
        this.recordList = recordList;
    }

    @Override
    public String toString() {
        return "PatientHistory{" +
                "recordList=" + recordList +
                '}';
    }
}
