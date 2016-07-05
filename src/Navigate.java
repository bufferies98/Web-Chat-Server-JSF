import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by shado on 7/4/2016.
 */

@ManagedBean
@SessionScoped
public class Navigate implements Serializable {
    public String Hub() {
        return "index.xhtml";
    }

    public String Login() {
        return "login.xhtml";
    }
}