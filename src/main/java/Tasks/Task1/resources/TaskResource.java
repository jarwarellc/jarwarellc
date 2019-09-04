package Tasks.Task1.resources;

import Tasks.Task1.models.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskResource {

    @RequestMapping("/")
    public byte[] getSign(@RequestBody Message msg) throws Exception {
        return msg.signMsg();
    }

}
