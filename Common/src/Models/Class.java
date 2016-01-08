package Models;

import java.io.Serializable;
import java.util.List;

public class Class implements Serializable, IEntity {
    private int classId;
    private String name = null;

    public Class(String name, int classId) {
        this.name = name;
        this.classId = classId;
    }

    @Override
    public int getPrimaryKey() {
        return classId;
    }

    public int getClassId() {
        return this.classId;
    }

    public String getName() {
        {
            return this.name;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<Eu> getEus() {
        return DataBaseEnv.currentProxy.loadObjectByReverseId(Eu.class, Class.class, classId);
    }

    public List<ClassBatch> getClassBatches() {
        return DataBaseEnv.currentProxy.loadObjectByReverseId(ClassBatch.class, Class.class, classId);
    }
}
