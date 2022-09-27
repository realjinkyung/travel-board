package model.domain.file;

public class FileDAOImpl implements FileDAO {


    private static FileDAO instance = new FileDAOImpl();

    private FileDAOImpl() {
    }

    public static FileDAO getInstance(){
        return instance;
    }
}
