package pl.soa.lab;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@Stateless
@WebService
public
class FileSender{
    @WebMethod
    @WebResult
    public String send(@WebParam(name="path") String path){
        File file = new File(path);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            System.out.println((int)file.length());
            System.out.println(file.length());
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes); }
        catch (FileNotFoundException e)
        { encodedfile="Nie ma takiego pliku"; }
        catch (IOException e)
        { encodedfile="Błąd przesyłu"; }
        return encodedfile; }
}

