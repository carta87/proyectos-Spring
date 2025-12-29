package com.ejemplo.batch.steps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Slf4j
public class ItemDescompressStep implements Tasklet {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("----------------> Inicio del paso de descompresion ---------------->");
        Resource resource = resourceLoader.getResource("classpath:file/person.zip");
        String filePath = resource.getFile().getAbsolutePath();

        // Implementación de la lógica para descomprimir el archivo zip
        ZipFile zipFile = new ZipFile(filePath);
        File destinoDir = new File(resource.getFile().getParent(), "destination");

        if(!destinoDir.exists()){
            destinoDir.mkdir();
        }

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()){
            ZipEntry zipEntry = entries.nextElement();
            File recurso = new File(destinoDir, zipEntry.getName());

            if(recurso.isDirectory()){
                recurso.mkdir();
            }else{
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                FileOutputStream outputStream = new FileOutputStream(recurso);

                byte[] buffer = new byte[1024];
                int lent = 0;
                while ((lent = inputStream.read(buffer))> 0){
                    outputStream.write(buffer, 0, lent);
                }
                outputStream.close();
                inputStream.close();
            }
        }
        zipFile.close();

        log.info("----------------> Fin del paso de descompresion ---------------->");
        return RepeatStatus.FINISHED;
    }
}
