import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by shado on 7/4/2016.
 */
@ManagedBean(name = "Navigate")
@SessionScoped
public class Navigate {
    public String Hub() {
        return "index.xhtml";
    }

    public String Login() {
        return "login.xhtml";
    }
}
