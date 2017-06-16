package com.farzad.utils.image;

import com.archimatetool.editor.model.compatibility.ModelCompatibility;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.ModelVersion;
import com.archimatetool.model.util.ArchimateResourceFactory;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VOLCANO on 5/1/2017.
 */
public class ModelTools {



     public static IArchimateModel loadModel(File modelFile) throws IOException {
        long startTime = System.currentTimeMillis();
        IArchimateModel model;
        // Create the Resource
        ArchimateResourceFactory.createResourceSet();
        IArchimatePackage pack = IArchimatePackage.eINSTANCE;
        Resource resource = ArchimateResourceFactory.createNewResource(modelFile);
        // Check model compatibility
        ModelCompatibility modelCompatibility = new ModelCompatibility(resource);
        // Load the model file
        Map<Object, Object> mergedOptions = new HashMap<Object, Object>();
        // mergedOptions.put(XMLResource.OPTION_DOM_USE_NAMESPACES_IN_SCOPE,
        // Boolean.FALSE);
        try {
            resource.load(FileUtils.openInputStream(modelFile), mergedOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!resource.isLoaded() || resource.getContents().isEmpty()) {
            throw new IOException("Couldn't load the resource for some reason");
        }
        model = (IArchimateModel) resource.getContents().get(0);
        // Once loaded - check for later model version
        boolean isLaterModelVersion = modelCompatibility.isLaterModelVersion(ModelVersion.VERSION);
        if (isLaterModelVersion) {
            // TODO whats this?
        }
        // Check for unknown model features which might be OK to load
        else {
            List<Resource.Diagnostic> exceptions = modelCompatibility.getAcceptableExceptions();
            if (!exceptions.isEmpty()) {
                String message = ""; //$NON-NLS-1$
                for (int i = 0; i < exceptions.size(); i++) {
                    if (i == 3) {
                        message += (exceptions.size() - 3) + " "; //$NON-NLS-1$
                        break;
                    }
                    message += exceptions.get(i).getMessage() + "\n"; //$NON-NLS-1$
                }
            }
        }
        // And then fix any backward compatibility issues
        // try {
        // modelCompatibility.fixCompatibility ();
        // } catch (CompatibilityHandlerException ex) {
        // }
        model.setFile(modelFile);
        model.setDefaults();
        long endTime = System.currentTimeMillis();
        System.out.println("Models loaded " + (endTime - startTime) + "ms");
        return model;
    }

}
