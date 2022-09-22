package service.file;

import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;

public class FileServiceImpl implements FileService{

    private static FileService instance = new FileServiceImpl();
    FileDAO fileDAO = FileDAOImpl.getInstance();
    private FileServiceImpl(){ }

    public FileService getInstance(){
        return instance;
    }
}
