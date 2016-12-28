package com.ibm.watson.visualrecognition.app;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.visualrecognition.util.PropertyUtil;

public class VisualRecognitionExample {

	public static void main(String[] args) {
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey(PropertyUtil.getInstance().getValue("bluemix.apikey"));

				System.out.println("Classify an image");
				ClassifyImagesOptions options =
						new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/prolineShirt.jpg")).build();
				VisualClassification result = service.classify(options).execute();
				System.out.println(result);

		//		service.deleteClassifier("proline_798492643").execute();
		//System.out.println(service.getClassifiers().execute());

		//Proline classification
		//		System.out.println("Classify an image");
		//		ClassifyImagesOptions options =
		//				new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/prolineShirt.jpg")).build();
		//		VisualClassification result = service.classify(options).execute();
		//		System.out.println(result);


//		System.out.println("Create a classifier with positive and negative images");
//		ClassifierOptions createOptions = new ClassifierOptions.Builder().classifierName("proline")
//				.addClass("fullSleeves", new File("src/test/resources/visual_recognition/proline/prolineFullSleeves.zip"))
//				.addClass("halfSleeves", new File("src/test/resources/visual_recognition/proline/prolineHalfSleeves.zip"))
//				.negativeExamples(new File("src/test/resources/visual_recognition/proline/negative.zip")).build();
//		VisualClassifier proline = service.createClassifier(createOptions).execute();
//		System.out.println(proline);

		//Proline classification
		System.out.println("Classify proline full sleeve image");
		 options = 
				new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/proline/fullsleeve.jpg"))
				.classifierIds("proline_1743651630").build();
		 result = service.classify(options).execute();
		System.out.println(result);

		System.out.println("Classify proline half sleeve image");
		options = 
				new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/proline/halfsleeve.jpg"))
				.classifierIds("proline_1743651630").build();
		result = service.classify(options).execute();
		System.out.println(result);


		//	    System.out.println("Classify using the 'Car' classifier");
		//	    options = new ClassifyImagesOptions.Builder().images(new File("src/test/resources/visual_recognition/images.jpg"))
		//	        .classifierIds("foo_177686944").build();
		//	    result = service.classify(options).execute();
		//	    System.out.println(result);

		//	    System.out.println("Update a classifier with more positive images");
		//	    ClassifierOptions updateOptions = new ClassifierOptions.Builder()
		//	        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip")).build();
		//	    VisualClassifier updatedFoo = service.updateClassifier(foo.getId(), updateOptions).execute();
		//	System.out.println(updatedFoo);
	}
}