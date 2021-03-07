package persistence;

import org.json.JSONObject;

//Interface to help us returns this as Json object
//CITATIONS: I used the code which is available on GITHUB of UBC JsonSerializationDemo with
//minor changes that I have done to the source code
public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
