public class EssaiModèle {

	private static final String WHERE = null;

	public static void query_model(String arg) throws IOException, ParseException {
		
		Model model = FileManager.get().loadModel(arg);
		//model.write(System.out,"Turtle");// (RDF/XML) & (N-triples) & (N3) & (Turtle)
		//essai d'application d'une requête qui extrait les noms des artistes à partir du fichier "5325.tll"
		String queryString = 
				

"prefix schema: <http://schema.org/>"+
"prefix cro:   <http://rhizomik.net/ontologies/copyrightonto#>"+
"prefix owl:   <http://www.w3.org/2002/07/owl#>"+
"prefix ecrm:  <http://erlangen-crm.org/current/> "+
"prefix xsd:   <http://www.w3.org/2001/XMLSchema#> "+
"prefix dcterms: <http://purl.org/dc/terms/> "+
"prefix efrbroo: <http://erlangen-crm.org/efrbroo/> "+
"prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> "+
"prefix mus:   <http://data.doremus.org/ontology#> "+
"prefix time:  <http://www.w3.org/2006/time#> "+
"prefix prov:  <http://www.w3.org/ns/prov#> "+
"prefix foaf:  <http://xmlns.com/foaf/0.1/> "+
"prefix dc:    <http://purl.org/dc/elements/1.1/> "+

	/////////////////////////Requête de la base F31//////////////////
//"SELECT    ?t1   ?d2  "+
//"WHERE{"+
//
//"?eventPrevu a mus:M26_Foreseen_Performance;"+
//"ecrm:P102_has_title ?t1_uri."+
//"?t1_uri rdfs:label ?t1."+
//"?eventPrevu a mus:M26_Foreseen_Performance;"+
//"mus:U8_foresees_time_span ?d2_uri."+
//"?d2_uri rdfs:label ?d2."+


"SELECT  ?t ?t2 ?d ?d2 ?e "+
"WHERE{"+ 



"?eventPrevu a mus:M26_Foreseen_Performance;"+
"mus:U8_foresees_time_span ?d_uri."+
"?d_uri rdfs:label ?d."+

"?eventPrevu a mus:M26_Foreseen_Performance;"+
"ecrm:P102_has_title ?t."+

"?event a efrbroo:F29_Recording_Event;"+
"ecrm:P32_used_general_technique ?e;"+
"ecrm:P4_has_time-span ?d2_uri."+
"?d2_uri rdfs:label ?d2."+
"?event a efrbroo:F29_Recording_Event;"+
"efrbroo:R20_recorded ?t2_uri."+
"?t2_uri ecrm:P102_has_title ?t2."+
"}";
	/////////////////////////Requête de la base M26//////////////////
//		          "SELECT ?id ?d ?p ?t "+
//				  "WHERE{"+ 
//				  "?eventPrevu a mus:M26_Foreseen_Performance;"+
//				  "mus:U7_foresees_place_at ?p_uri."+
//				  
//				  "?p_uri rdfs:label ?p."+
//				  "?eventPrevu a mus:M26_Foreseen_Performance;"+
//
//				  "mus:U8_foresees_time_span ?d_uri."+
//				  "?d_uri rdfs:label ?d."+
//				  "?eventPrevu a mus:M26_Foreseen_Performance;"+
//
//				  "ecrm:P102_has_title ?t."+
//				  "?eventPrevu a mus:M26_Foreseen_Performance;"+
//
//				  "dc:identifier ?id."+
//				  "?eventPrevu a mus:M26_Foreseen_Performance;"+
//
//				  "}ORDER BY ?id";
			
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect();
			
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
//				Literal p = soln.getLiteral("p");
//			    Literal n = soln.getLiteral("n");
//				Literal t = soln.getLiteral("t");
//				
//				System.out.println(t+ "----"+n+"---");
				ResultSetFormatter.out(System.out,results,query);
				//simple way to print result
				//model.write(System.out,"Turtle");
			}
			
		}finally {
			
			
		}
		
		
	}

		
	}
