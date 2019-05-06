package devpro.vn.baitapvenha_sqlite;

/**
 * Created by nguye on 5/11/2018.
 */

public class StudentModel  {
         private  int id;
         private String name;
         private  int old;
         private String add;
         private String nameClas;

    public StudentModel() {
        this.id = id;
        this.name = name;
        this.old = old;
        this.add = add;
        this.nameClas = nameClas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getNameClas() {
        return nameClas;
    }

    public void setNameClas(String nameClas) {
        this.nameClas = nameClas;
    }
}
