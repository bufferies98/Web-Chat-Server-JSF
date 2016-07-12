import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shado on 7/4/2016.
 */

@ManagedBean(name = "Messages", eager = true)
@ApplicationScoped
public class Messages implements Serializable {
    private List<String> messageList = new ArrayList<String>();

    public void setMessageList(String msg) {
        messageList.add(msg);
    }

    public List<String> getMessageList() {
        return messageList;
    }
}
