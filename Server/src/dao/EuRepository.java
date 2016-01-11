package dao;

import Models.Class;
import Models.Eu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EuRepository extends DaoBase<Eu> {

    private static final String SElECTREQUEST = "SELECT * FROM Ue ";
    private static final String TABLENAME = "Ue";

    private static EuRepository instance = null;
    public static EuRepository getInstance() {
        if(instance == null)
            instance = new EuRepository();
        return instance;
    }

    public EuRepository() {
        super(TABLENAME);
    }

    public static Eu getById(int id) {
        ArrayList<Eu> ar = getInstance().select(SElECTREQUEST + "WHERE UeId = " + id);
        return ar.size() > 0 ? ar.get(0) : null;
    }

    public static List<Eu> getByReverseId(java.lang.Class<?> clazz, int id) {
        String column = null;
        if(clazz == Class.class) column = "classId";
        if(column == null) {
            System.err.println(String.format("%s.getByReverseId: Class not found : %s",
                    getInstance().getClass().getSimpleName(), clazz.getClass().getSimpleName()));
            return null;
        }
        return getInstance().select(SElECTREQUEST + "WHERE " + column + " = " + id);
    }

    @Override
    public Eu dataToClass(ResultSet rs) throws SQLException {
        return new Eu(
                rs.getInt("UeId"),
                rs.getInt("ClassId"),
                rs.getString("Nom")
        );
    }
}
