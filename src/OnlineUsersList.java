import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shado on 7/4/2016.
 */
@ManagedBean(name = "OnlineUsersList")
@SessionScoped
public class OnlineUsersList {
    List<User> userList = new ArrayList<User>();

    public String addOnlineUser (String name) {
        User user = new User(name);
        userList.add(user);
        return "index.xhtml";
    }

    public List<User> getUserList() {
        return userList;
    }
}
