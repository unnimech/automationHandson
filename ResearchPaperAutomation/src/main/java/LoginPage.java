import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	//@Test(dataProvider = "AbstractList")	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		fetchData();

		
	}
	
	
	public static void fetchData() throws InterruptedException, IOException
	{	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\unni_\\OneDrive\\Documents\\chromedriver_86.exe");
		WebDriver driver = new ChromeDriver();
		
		String[][] AbstractList= dataProviderMethod();
		for(int i=0;i<AbstractList.length;i++) {
			String temp= AbstractList[i][0];
		TestFlow(driver,AbstractList[i][0]);
		}
		
		 driver.close();
	        
	     driver.quit();
	}
	
	//@Test(dataProvider = "AbstractList")	
	public static void TestFlow(WebDriver driver,String AbstractTopic) throws InterruptedException, IOException
	{
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        String baseUrl = "https://pubmed.ncbi.nlm.nih.gov/advanced/";
        //String expectedTitle = "Welcome: Mercury Tours";
        //String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        Thread.sleep(3000);
        Select fieldType= new Select(driver.findElement(By.xpath("//*[@id=\"field-selector\"]")));
        fieldType.selectByValue("Title");
        
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        WebElement AbtractTextField = driver.findElement(By.cssSelector("input[id='id_term']"));
        AbtractTextField.sendKeys(AbstractTopic);
        
        Thread.sleep(1000);
        
        //driver.wait(5);
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/div/div/div[4]/div[3]/button")).click();
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/div/div/div[6]/div[2]/button[2]")).click();
        Thread.sleep(3000);
        WebElement AbtractText=null;
        
        if(driver.findElements(By.xpath("//*[@id=\"enc-abstract\"]/p")).size() > 0) {
             
        AbtractText =driver.findElement(By.xpath("//*[@id=\"enc-abstract\"]/p"));
        writeToCSV(AbstractTopic,AbtractText.getText());
        }
        //System.out.print(AbtractText.getText());
        
        

        // get the actual value of the title
        //actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        /*if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }*/
       
        //close Fire fox
       
       
	}
	
	
	
	//@DataProvider(name = "AbstractList")
    public static String[][] dataProviderMethod() {
        return new String[][] {           	
        	{"\"MiR-506 suppresses cell proliferation and tumor growth by targeting Rho-associated protein kinase 1 in hepatocellular carcinoma.\""},
        	{"\"MiR-506 is down-regulated in clear cell renal cell carcinoma and inhibits cell growth and metastasis via targeting FLOT1.\""},
        	{"\"Correction: MiR-506 Is Down-Regulated in Clear Cell Renal Cell Carcinoma and Inhibits Cell Growth and Metastasis via Targeting FLOT1.\""},
        	{"\"CTGF increases matrix metalloproteinases expression and subsequently promotes tumor metastasis in human osteosarcoma through down-regulating miR-519d.\""},
        	{"\"Study on the relationship between miR-520g and the development of breast cancer.\""},
        	{"\"MicroRNA-548p suppresses hepatitis B virus X protein associated hepatocellular carcinoma by downregulating oncoprotein HBXIP.\""},
        	{"\"Combination of Endothelial-Monocyte-Activating Polypeptide-II with Temozolomide Suppress Malignant Biological Behaviors of Human Glioblastoma Stem Cells via miR-590-3p/MACC1 Inhibiting PI3K/AKT/mTOR S\""},
        	{"\"MicroRNA-590-5p functions as a tumor suppressor in breast cancer conferring inhibitory effects on cell migration, invasion, and epithelial-mesenchymal transition by downregulating the Wnt-?-catenin si\""},
        	{"\"Hypoxia-induced microRNA-590-5p promotes colorectal cancer progression by modulating matrix metalloproteinase activity.\""},
        	{"\"The miR-599 promotes non-small cell lung cancer cell invasion via SATB2.\""},
        	{"\"Downregulation of miR-610 promotes proliferation and tumorigenicity and activates Wnt/?-catenin signaling in human hepatocellular carcinoma.\""},
        	{"\"miR-613 inhibits proliferation and invasion of breast cancer cell via VEGFA.\""},
        	{"\"MiRNA-615-5p functions as a tumor suppressor in pancreatic ductal adenocarcinoma by targeting AKT2.\""},
        	{"\"Correction: MiRNA-615-5p Functions as a Tumor Suppressor in Pancreatic Ductal Adenocarcinoma by Targeting AKT2.\""},
        	{"\"Hsa-miR-623 suppresses tumor progression in human lung adenocarcinoma.\""},
        	{"\"Correction to: Hsa-miR-623 suppresses tumor progression in human lung adenocarcinoma.\""},
        	{"\"miR-625 suppresses tumour migration and invasion by targeting IGF2BP1 in hepatocellular carcinoma.\""},
        	{"\"Downregulation of microRNA-217 and microRNA-646 acts as potential predictor biomarkers in progression, metastasis, and unfavorable prognosis of human osteosarcoma.\""},
        	{"\"MicroRNA-647 Targets SRF-MYH9 Axis to Suppress Invasion and Metastasis of Gastric Cancer.\""},
        	{"\"Mir-655 up-regulation suppresses cell invasion by targeting pituitary tumor-transforming gene-1 in esophageal squamous cell carcinoma.\""},
        	{"\"Long Non-Coding RNA H19 Promotes Glioma Cell Invasion by Deriving miR-675.\""},
        	{"\"MicroRNA-744 promotes prostate cancer progression through aberrantly activating Wnt/?-catenin signaling.\""},
        	{"\"Overexpression of miR-758 inhibited proliferation, migration, invasion, and promoted apoptosis of non-small cell lung cancer cells by negatively regulating HMGB.\""},
        	{"\"MicroRNA-760 Inhibits Doxorubicin Resistance in Hepatocellular Carcinoma through Regulating Notch1/Hes1-PTEN/Akt Signaling Pathway.\""},
        	{"\"MiR-760 suppresses non-small cell lung cancer proliferation and metastasis by targeting ROS1.\""},
        	{"\"Hsa-miRNA-765 as a Key Mediator for Inhibiting Growth, Migration and Invasion in Fulvestrant-Treated Prostate Cancer.\""},
        	{"\"MiR-873 regulates ER? transcriptional activity and tamoxifen resistance via targeting CDK3 in breast cancer cells.\""},
        	{"\"miR-874 functions as a tumor suppressor by inhibiting angiogenesis through STAT3/VEGF-A pathway in gastric cancer.\""},
        	{"\"Correction: miR-874 functions as a tumor suppressor by inhibiting angiogenesis through STAT3/VEGF-A pathway in gastric cancer.\""},
        	{"\"MiR-877-5p suppresses cell growth, migration and invasion by targeting cyclin dependent kinase 14 and predicts prognosis in hepatocellular carcinoma.\""},
        	{"\"Comment on: MiR-877-5p suppresses cell growth, migration and invasion by targeting cyclin dependent kinase 14 and predicts prognosis in hepatocellular carcinoma.\""},
        	{"\"miR-885-5p suppresses hepatocellular carcinoma metastasis and inhibits Wnt/?-catenin signaling pathway.\""},
        	{"\"Yin Yang 1-mediated epigenetic silencing of tumour-suppressive microRNAs activates nuclear factor-?B in hepatocellular carcinoma.\""},
        	{"\"Inhibition of MicroRNA miR-92a Inhibits Cell Proliferation in Human Acute Promyelocytic Leukemia.\""},
        	{"\"MicroRNA-92a Promotes Colorectal Cancer Cell Growth and Migration by Inhibiting KLF4.\""},
        	{"\"In vitro and in vivo activity of miR-92a-Locked Nucleic Acid (LNA)-Inhibitor against endometrial cancer.\""},
        	{"\"miR-93-5p/IFNAR1 axis promotes gastric cancer metastasis through activating the STAT3 signaling pathway.\""},
        	{"\"microRNA-98 inhibits the proliferation, invasion, migration and promotes apoptosis of breast cancer cells by binding to HMGA2.\""},
        	{"\"PLGA-based dual targeted nanoparticles enhance miRNA transfection efficiency in hepatic carcinoma.\""},
        	{"\"WITHDRAWN: MicroRNA-99a Suppresses Proliferation, Migration, Invasion and Induces G1-phase Cell Cycle Arrest via Targeting Insulin-like Growth Factor 1 Receptor Pathway in Renal Cell Carcinoma 786-0 a\""},
        	{"\"The role of miR-99b in mediating hepatocellular carcinoma invasion and migration.\""},
        	{"\"MicroRNA-33a and let-7e inhibit human colorectal cancer progression by targeting ST8SIA1.\""},
        	{"\"Expression of 19 microRNAs in glioblastoma and comparison with other brain neoplasia of grades I-III.\""},
        	{"\"Upregulation of miR-20a and miR-10a expression levels act as potential biomarkers of aggressive progression and poor prognosis in cervical cancer.\""},
        	{"\"Circulating microRNAs, miR-21, miR-122, and miR-223, in patients with hepatocellular carcinoma or chronic hepatitis.\""},
        	{"\"[MicroRNA profiling in patients with hepatocellular carcinoma].\""},
        	{"\"[miR-124 suppresses cell proliferation and invasion in gastric carcinoma and its mechanism].\""},
        	{"\"MiR-124 Functions as a Tumor Suppressor via Targeting hCLOCK1 in Glioblastoma.\""},
        	{"\"The tumor suppressor role of miR-124 in osteosarcoma.\""},
        	{"\"Upregulation of miR-300 and downregulation of miR-125b act as potential predictor biomarkers in progression, metastasis, and poor prognosis of osteosarcoma.\""},
        	{"\"miR-126: A novel regulator in colon cancer.\""},
        	{"\"Down-regulation of miR-126 expression in colorectal cancer and its clinical significance.\""},
        	{"\"Experimental study on the prevention of liver cancer angiogenesis via miR-126.\""},
        	{"\"miR-126 functions as a tumor suppressor in osteosarcoma by targeting Sox2.\""},
        	{"\"Clinical evaluation of microRNA expression profiling in non small cell lung cancer.\""},
        	{"\"Regulation of minichromosome maintenance gene family by microRNA-1296 and genistein in prostate cancer.\""},
        	{"\"MicroRNA-130b promotes cell migration and invasion by targeting peroxisome proliferator-activated receptor gamma in human glioma.\""},
        	{"\"Downregulation of miR-130b~301b cluster is mediated by aberrant promoter methylation and impairs cellular senescence in prostate cancer.\""},
        	{"\"Tumor suppressor functions of miR-133a in colorectal cancer.\""},
        	{"\"The clinicopathological significance of miR-133a in colorectal cancer.\""},
        	{"\"MicroRNA-133a functions as a tumor suppressor in gastric cancer.\""},
        	{"\"Profiling of circulating microRNAs in patients with Barrett's esophagus and esophageal adenocarcinoma.\""},
        	{"\"Downregulation of miR-133b/miR-503 acts as efficient prognostic and diagnostic factors in patients with osteosarcoma and these predictor biomarkers are correlated with overall survival.\""},
        	{"\"MicroRNA-134 functions as a tumor suppressor gene in gastric cancer.\""},
        	{"\"Correction: miR-135b Promotes Cancer Progression by Targeting Transforming Growth Factor Beta Receptor II (TGFBR2) in Colorectal Cancer.\""},
        	{"\"miR-135b Promotes Cancer Progression by Targeting Transforming Growth Factor Beta Receptor II (TGFBR2) in Colorectal Cancer.\""},
        	{"\"Effects of microRNA-136 on melanoma cell proliferation, apoptosis, and epithelial-mesenchymal transition by targetting PMEL through the Wnt signaling pathway.\""},
        	{"\"MicroRNA-137 inhibits cell migration and invasion by targeting bone morphogenetic protein-7 (BMP7) in non-small cell lung cancer cells.\""},
        	{"\"MiR-137 suppresses tumor growth and metastasis in clear cell renal cell carcinoma.\""},
        	{"\"New miRNA expression abnormalities in laryngeal squamous cell carcinoma.\""},
        	{"\"MiR-140-5p suppresses retinoblastoma cell growth via inhibiting c-Met/AKT/mTOR pathway.\""},
        	{"\"Circulating microRNAs in serum: novel biomarkers for patients with bladder cancer?\""},
        	{"\"Expression of microRNAs in the Urine of Patients With Bladder Cancer.\""},
        	{"\"MiR-200 suppresses metastases of colorectal cancer through ZEB1.\""},
        	{"\"MicroRNA-141 suppresses prostate cancer stem cells and metastasis by targeting a cohort of pro-metastasis genes.\""},
        	{"\"Re: MicroRNA-141 Suppresses Prostate Cancer Stem Cells and Metastasis by Targeting a Cohort of Pro-Metastasis Genes.\""},
        	{"\"miR-142-5p promotes development of colorectal cancer through targeting SDHB and facilitating generation of aerobic glycolysis.\""},
        	{"\"Uncovering growth-suppressive MicroRNAs in lung cancer.\""},
        	{"\"MicroRNA-143 as a tumor suppressor for bladder cancer.\""},
        	{"\"miR-143 or miR-145 overexpression increases cetuximab-mediated antibody-dependent cellular cytotoxicity in human colon cancer cells.\""},
        	{"\"MicroRNA signatures: novel biomarker for colorectal cancer?\""},
        	{"\"[Effect of microRNA143 expression on cell proliferation in colonic carcinoma].\""},
        	{"\"MiR-143 inhibits tumor cell proliferation and invasion by targeting STAT3 in esophageal squamous cell carcinoma.\""},
        	{"\"miR-143 inhibits tumor progression by targeting FAM83F in esophageal squamous cell carcinoma.\""},
        	{"\"Erratum to: miR-143 inhibits tumor progression by targeting FAM83F in esophageal squamous cell carcinoma.\""},
        	{"\"[Expression of miR-143 and miR-145 and their functional study in gastric carcinoma].\""},
        	{"\"MicroRNA-143 targets Syndecan-1 to repress cell growth in melanoma.\""},
        	{"\"Suppressive effect of microRNA-143 in retinoblastoma.\""},
        	{"\"MiR-143-3p suppresses the progression of ovarian cancer.\""},
        	{"\"MicroRNA-144-3p inhibits cell proliferation and induces cell apoptosis in prostate cancer by targeting CEP55.\""},
        	{"\"Aberrant expression of microRNAs in bladder cancer.\""},
        	{"\"[miR-145 inhibits lung adenocarcinoma stem cells proliferation by targeting OCT4 gene].\""},
        	{"\"Serum levels of candidate microRNA diagnostic markers differ among the stages of non-small-cell lung cancer.\""},
        	{"\"The functional significance of microRNA-145 in prostate cancer.\""},
        	{"\"Regulation of COX-2 expression by miR-146a in lung cancer cells.\""},
        	{"\"MicroRNA analysis as a potential diagnostic tool for papillary thyroid carcinoma.\""},
        	{"\"The role of miR-148a in gastric cancer.\""},
        	{"\"MiR-148b suppresses cell proliferation and invasion in hepatocellular carcinoma by targeting WNT1/?-catenin pathway.\""},
        	{"\"Downregulation of miR-148b as biomarker for early detection of hepatocellular carcinoma and may serve as a prognostic marker.\""},
        	{"\"Profiles of tissue microRNAs; miR-148b and miR-25 serve as potential prognostic biomarkers for hepatocellular carcinoma.\""},
        	{"\"Down-regulated MicroRNA 148b expression as predictive biomarker and its prognostic significance associated with clinicopathological features in non-small-cell lung cancer patients.\""},
        	{"\"Opposite prognostic significance of cellular and serum circulating microRNA-150 in Chronic Lymphocytic Leukemia patients.\""},
        	{"\"MiR-150 alleviates EMT and cell invasion of colorectal cancer through targeting Gli1.\""},
        	{"\"[MicroRNA-150 inhibits osteosarcoma cell proliferation by targeting RUNX2 gene].\""},
        	{"\"Long non-coding RNA linc00673 regulated non-small cell lung cancer proliferation, migration, invasion and epithelial mesenchymal transition by sponging miR-150-5p.\""},
        	{"\"[MiR-150-5p inhibits the proliferation and promoted apoptosis of pancreatic cancer cells].\""},
        	{"\"Downregulation of MicroRNA-152 and Inhibition of Cell Proliferation, Migration, and Invasion in Breast Cancer.\""},
        	{"\"miR-152 is a tumor suppressor microRNA that is silenced by DNA hypermethylation in endometrial cancer.\""},
        	{"\"Role of MicroRNAs in carcinogenesis that potential for biomarker of endometrial cancer.\""},
        	{"\"miR-153 suppresses IDO1 expression and enhances CAR T cell immunotherapy.\""},
        	{"\"MiRNA153 Reduces Effects of Chemotherapeutic Agents or Small Molecular Kinase Inhibitor in HCC Cells.\""},
        	{"\"[Expression and its clinical significance of miR-155 in human primary breast cancer].\""},
        	{"\"Clinical significance of MicoRNA-155 expression in human breast cancer.\""},
        	{"\"MicroRNA-155 regulates cell survival, growth, and chemosensitivity by targeting FOXO3a in breast cancer.\""},
        	{"\"Clinical significance of microRNA-155 expression in hepatocellular carcinoma.\""},
        	{"\"Aberrant microRNA expression in Chinese patients with chronic lymphocytic leukemia.\""},
        	{"\"Downregulation of miR-15a and miR-16-1 at 13q14 in Chronic Lymphocytic Leukemia.\""},
        	{"\"A microRNA code for prostate cancer metastasis.\""},
        	{"\"miR-15a and miR-16 are implicated in cell cycle regulation in a Rb-dependent manner and are frequently deleted or down-regulated in non-small cell lung cancer.\""},
        	{"\"Circulating microRNAs as biomarkers for hepatocellular carcinoma.\""},
        	{"\"Circulating Serum miRNAs as Diagnostic Markers for Colorectal Cancer.\""},
        	{"\"MiR-17-5p promotes cervical cancer cell proliferation and metastasis by targeting transforming growth factor-? receptor 2.\""},
        	{"\"Regulation of cancer aggressive features in melanoma cells by microRNAs.\""},
        	{"\"[MiR-181a Promotes Proliferation of Human Acute Myeloid Leukemia Cells by Targeting ATM].\""},
        	{"\"MiR-181a regulates blood-tumor barrier permeability by targeting Kr?ppel-like factor 6.\""},
        	{"\"MicroRNA-182 drives metastasis of primary sarcomas by targeting multiple genes.\""},
        	{"\"MiR-182 affects renal cancer cell proliferation, apoptosis, and invasion by regulating PI3K/AKT/mTOR signaling pathway.\""},
        	{"\"miR-182-5p promotes hepatocellular carcinoma progression by repressing FOXO3a.\""},
        	{"\"MicroRNA expression signatures of bladder cancer revealed by deep sequencing.\""},
        	{"\"Expression of microRNA-184 in glioma.\""},
        	{"\"Downregulation of miR-185 and upregulation of miR-218 expression may be potential diagnostic and prognostic biomarkers of human chondrosarcoma.\""},
        	{"\"MiR-186 inhibited aerobic glycolysis in gastric cancer via HIF-1? regulation.\""},
        	{"\"Effects of downregulated expression of microRNA-187 in gastric cancer.\""},
        	{"\"Plasma miR-187* is a potential biomarker for oral carcinoma.\""},
        	{"\"Regulation of growth of human bladder cancer by miR-192.\""},
        	{"\"A novel serum microRNA signature to screen esophageal squamous cell carcinoma.\""},
        	{"\"Pathologically decreased expression of miR-193a contributes to metastasis by targeting WT1-E-cadherin axis in non-small cell lung cancers.\""},
        	{"\"miR-193a-3p functions as a tumor suppressor in lung cancer by downregulating ERBB4.\""},
        	{"\"miR-193b Regulates Mcl-1 in Melanoma.\""},
        	{"\"MicroRNA-195 plays a tumor-suppressor role in human glioblastoma cells by targeting signaling pathways involved in cellular proliferation and invasion.\""},
        	{"\"Diagnostic and prognostic value of plasma microRNA-195 in patients with non-small cell lung cancer.\""},
        	{"\"miR-195-5p Suppresses the Proliferation, Migration, and Invasion of Oral Squamous Cell Carcinoma by Targeting TRIM14.\""},
        	{"\"MicroRNAs in Barrett's esophagus and esophageal adenocarcinoma.\""},
        	{"\"MiR-196a Is Up-regulated in Gastric cancer and Promotes Cell proliferation by Down-regulating p27kip1.\""},
        	{"\"Epigenetic regulation of miR-196b expression in gastric cancer.\""},
        	{"\"miRNA-199a-5p suppresses proliferation and invasion by directly targeting NF-?B1 in human ovarian cancer cells.\""},
        	{"\"MicroRNA-199b-5p attenuates TGF-?1-induced epithelial-mesenchymal transition in hepatocellular carcinoma.\""},
        	{"\"miR-199b-5p serves as a tumor suppressor in renal cell carcinoma.\""},
        	{"\"MiR-19a promotes epithelial-mesenchymal transition through PI3K/AKT pathway in gastric cancer.\""},
        	{"\"Upregulation of MicroRNA-19b predicts good prognosis in patients with hepatocellular carcinoma presenting with vascular invasion or multifocal disease.\""},
        	{"\"Gastric adenocarcinoma has a unique microRNA signature not present in esophageal adenocarcinoma.\""},
        	{"\"miR-200b as a prognostic factor in breast cancer targets multiple members of RAB family.\""},
        	{"\"[miR-200b suppresses glioma cell invasion by targeting PROM1].\""},
        	{"\"A proposed method for the relative quantification of levels of circulating microRNAs in the plasma of gastric cancer patients.\""},
        	{"\"BANF1 Is Downregulated by IRF1-Regulated MicroRNA-203 in Cervical Cancer.\""},
        	{"\"Identification of microRNAs (miR-203/miR-7) as potential markers for the early detection of lymph node metastases in patients with cervical cancer.\""},
        	{"\"MicroRNA-203 suppresses gastric cancer growth by targeting PIBF1/Akt signaling.\""},
        	{"\"Retraction Note: MicroRNA-203 suppresses gastric cancer growth by targeting PIBF1/Akt signaling.\""},
        	{"\"MiRNA-203 suppresses tumor cell proliferation, migration and invasion by targeting Slug in gastric cancer.\""},
        	{"\"Development and validation of nomogram based on miR-203 and clinicopathological characteristics predicting survival after neoadjuvant chemotherapy and surgery for patients with non-metastatic osteosar\""},
        	{"\"Loss of EGFR signaling regulated miR-203 promotes prostate cancer bone metastasis and tyrosine kinase inhibitors resistance.\""},
        	{"\"MicroRNA expression profiles of esophageal cancer.\""},
        	{"\"Downregulation of miR-204 expression correlates with poor clinical outcome of glioma patients.\""},
        	{"\"MicroRNA-204 deregulation in lung adenocarcinoma controls the biological behaviors of endothelial cells potentially by modulating Janus kinase 2-signal transducer and activator of transcription 3 path\""},
        	{"\"MicroRNA-204 inhibits proliferation, migration, invasion and epithelial-mesenchymal transition in osteosarcoma cells via targeting Sirtuin 1.\""},
        	{"\"VHL-regulated MiR-204 suppresses tumor growth through inhibition of LC3B-mediated autophagy in renal clear cell carcinoma.\""},
        	{"\"[Effect of microRNA-205 on proliferation of laryngeal carcinoma cell line Hep-2].\""},
        	{"\"miR-205 regulates A549 cells proliferation by targeting PTEN.\""},
        	{"\"MicroRNA-205 inhibits cancer cell migration and invasion via modulation of centromere protein F regulating pathways in prostate cancer.\""},
        	{"\"Editorial Comment to MicroRNA-205 inhibits cancer cell migration and invasion via modulation of centromere protein F regulating pathways in prostate cancer.\""},
        	{"\"MiR-206 functions as a tumor suppressor and directly targets K-Ras in human oral squamous cell carcinoma.\""},
        	{"\"MiR-206 functions as a tumor suppressor and directly targets K-Ras in human oral squamous cell carcinoma [Retraction].\""},
        	{"\"Radiation-induced miR-208a increases the proliferation and radioresistance by targeting p21 in human lung cancer cells.\""},
        	{"\"miR-21 expression predicts prognosis in diffuse large B-cell lymphoma.\""},
        	{"\"Next-generation sequencing of microRNAs for breast cancer detection.\""},
        	{"\"Circulating plasma microRNAs in the detection of esophageal squamous cell carcinoma.\""},
        	{"\"Circulating microRNAs in plasma of patients with oesophageal squamous cell carcinoma.\""},
        	{"\"Serum microRNA-21 is a novel biomarker in patients with esophageal squamous cell carcinoma.\""},
        	{"\"Downregulation of microRNA-21 inhibited radiation-resistance of esophageal squamous cell carcinoma.\""},
        	{"\"MicroRNA-21 promotes TGF-?1-induced epithelial-mesenchymal transition in gastric cancer through up-regulating PTEN expression.\""},
        	{"\"Prognostic role of microRNA-21 expression in gliomas: a meta-analysis.\""},
        	{"\"[Expression of mir-21 and mir-375 in laryngeal squamous cell carcinoma].\""},
        	{"\"MicroRNA alterations in head and neck squamous cell carcinoma.\""},
        	{"\"MicroRNA-21 suppresses PTEN and hSulf-1 expression and promotes hepatocellular carcinoma progression through AKT/ERK pathways.\""},
        	{"\"miR-21 expression predicts prognosis in hepatocellular carcinoma.\""},
        	{"\"Increased expression of miR-21 predicts poor prognosis in patients with hepatocellular carcinoma.\""},
        	{"\"Up-Regulation of miR-21 Expression Predicate Advanced Clinicopathological Features and Poor Prognosis in Patients with Non-Small Cell Lung Cancer.\""},
        	{"\"[Overexpression of miR-21 promotes proliferation and reduces apoptosis in non-small cell lung cancer].\""},
        	{"\"Berberine-targeted miR-21 chemosensitizes oral carcinomas stem cells.\""},
        	{"\"Inhibition of microRNA-21-3p suppresses proliferation as well as invasion and induces apoptosis by targeting RNA-binding protein with multiple splicing through Smad4/extra cellular signal-regulated pr\""},
        	{"\"Serum miR-210 as a potential biomarker of early clear cell renal cell carcinoma.\""},
        	{"\"Effects of miR-214 on cervical cancer cell proliferation, apoptosis and invasion via modulating PI3K/AKT/mTOR signal pathway.\""},
        	{"\"Knockdown of miR-214 Promotes Apoptosis and Inhibits Cell Proliferation in Nasopharyngeal Carcinoma.\""},
        	{"\"MicroRNA-214-3p inhibits proliferation and cell cycle progression by targeting MELK in hepatocellular carcinoma and correlates cancer prognosis.\""},
        	{"\"Predictive Value of Plasma MicroRNA-216a/b in the Diagnosis of Esophageal Squamous Cell Carcinoma.\""},
        	{"\"MicroRNA-216b is Down-Regulated in Human Gastric Adenocarcinoma and Inhibits Proliferation and Cell Cycle Progression by Targeting Oncogene HDAC8.\""},
        	{"\"Retraction Note to: MicroRNA-216b is Down-Regulated in Human Gastric Adenocarcinoma and Inhibits Proliferation and Cell Cycle Progression by Targeting Oncogene HDAC8.\""},
        	{"\"MicroRNA-217 suppressed epithelial-to-mesenchymal transition in gastric cancer metastasis through targeting PTPN14.\""},
        	{"\"MicroRNA-218 increases cellular sensitivity to Rapamycin via targeting Rictor in cervical cancer.\""},
        	{"\"Decreased expression of miR-218 is associated with poor prognosis in patients with colorectal cancer.\""},
        	{"\"[Reduced expression of miR-218 and its significance in gastric cancer].\""},
        	{"\"Inhibition of pulmonary carcinoma proliferation or metastasis of miR-218 via down-regulating CDCP1 expression.\""},
        	{"\"MiR-218 promotes apoptosis of U2OS osteosarcoma cells through targeting BIRC5.\""},
        	{"\"MicroRNA-22 inhibits proliferation, invasion and metastasis of breast cancer cells through targeting truncated neurokinin-1 receptor and ER?.\""},
        	{"\"Clinical significance of miR-22 expression in patients with colorectal cancer.\""},
        	{"\"Reduced expression of miR-22 in gastric cancer is related to clinicopathologic characteristics or patient prognosis.\""},
        	{"\"TRPS1 targeting by miR-221/222 promotes the epithelial-to-mesenchymal transition in breast cancer.\""},
        	{"\"MicroRNA-221 inhibits CDKN1C/p57 expression in human colorectal carcinoma.\""},
        	{"\"Increased MiR-221 expression in hepatocellular carcinoma tissues and its role in enhancing cell growth and inhibiting apoptosis in vitro.\""},
        	{"\"In vivo imaging of functional targeting of miR-221 in papillary thyroid carcinoma.\""},
        	{"\"Increased expression of miR-222 is associated with poor prognosis in bladder cancer.\""},
        	{"\"Analysis of serum genome-wide microRNAs for breast cancer detection.\""},
        	{"\"Increased miR-222 in H. pylori-associated gastric cancer correlated with tumor progression by promoting cancer cell proliferation and targeting RECK.\""},
        	{"\"Clinical significance of serum miR-223, miR-25 and miR-375 in patients with esophageal squamous cell carcinoma.\""},
        	{"\"[Expression of miR-223 in clear cell renal cell carcinoma and its significance].\""},
        	{"\"MicroRNA-223-3p inhibits human bladder cancer cell migration and invasion.\""},
        	{"\"miR-224 promotes cell migration and invasion by modulating p-PAK4 and MMP-9 via targeting HOXD10 in human hepatocellular carcinoma.\""},
        	{"\"Decreased microRNA-224 and its clinical significance in non-small cell lung cancer patients.\""},
        	{"\"MicroRNA-224 promotes the sensitivity of osteosarcoma cells to cisplatin by targeting Rac1.\""},
        	{"\"Revealing genome-wide mRNA and microRNA expression patterns in leukemic cells highlighted \"hsa-miR-2278\" as a tumor suppressor for regain of chemotherapeutic imatinib response due to targeti\""},
        	{"\"c-MYC regulated miR-23a~24-2~27a cluster promotes mammary carcinoma cell invasion and hepatic metastasis by targeting Sprouty2.\""},
        	{"\"miR-23a targets interferon regulatory factor 1 and modulates cellular proliferation and paclitaxel-induced apoptosis in gastric adenocarcinoma cells.\""},
        	{"\"MicroRNAs and clinical implications in hepatocellular carcinoma.\""},
        	{"\"MiR-23a Functions as a Tumor Suppressor in Osteosarcoma.\""},
        	{"\"MiR-23a-3p acts as an oncogene and potential prognostic biomarker by targeting PNRC2 in RCC.\""},
        	{"\"miR-23b suppresses lung carcinoma cell proliferation through CCNG1.\""},
        	{"\"miR-23c suppresses tumor growth of human hepatocellular carcinoma by attenuating ERBB2IP.\""},
        	{"\"MicroRNA-24 upregulation inhibits proliferation, metastasis and induces apoptosis in bladder cancer cells by targeting CARMA3.\""},
        	{"\"MiR-24 promotes the proliferation and apoptosis of lung carcinoma via targeting MAPK7.\""},
        	{"\"MicroRNA-25 suppresses proliferation, migration, and invasion of osteosarcoma by targeting SOX4.\""},
        	{"\"MicroRNA-26a suppresses angiogenesis in human hepatocellular carcinoma by targeting HGF-cmet pathway.\""},
        	{"\"MiRNA-26b inhibits proliferation by targeting PTGS2 in breast cancer.\""},
        	{"\"MicroRNA 26b promotes colorectal cancer metastasis by down-regulating PTEN and WNT5A.\""},
        	{"\"MiR-26b suppresses cell proliferation and invasion by targeting cyclooxygenase 2 in human glioblastoma.\""},
        	{"\"B4GALT3 up-regulation by miR-27a contributes to the oncogenic activity in human cervical cancer cells.\""},
        	{"\"Cell-Free miR-27a, a Potential Diagnostic and Prognostic Biomarker for Gastric Cancer.\""},
        	{"\"Down-regulation of microRNA-26a and up-regulation of microRNA-27a contributes to aggressive progression of human osteosarcoma.\""},
        	{"\"Expression and function of miR-27b in human glioma.\""},
        	{"\"miR-28-5p promotes the development and progression of ovarian cancer through inhibition of N4BP1.\""},
        	{"\"Negative feedback of miR-29 family TET1 involves in hepatocellular cancer.\""},
        	{"\"Up-regulation of histone methyltransferase SETDB1 by multiple mechanisms in hepatocellular carcinoma promotes cancer metastasis.\""},
        	{"\"Tissue expression levels of miR-29b and miR-422a in children, adolescents, and young adults' age groups and their association with prediction of poor prognosis in human osteosarcoma.\""},
        	{"\"miR-29c suppresses pancreatic cancer liver metastasis in an orthotopic implantation model in nude mice and affects survival in pancreatic cancer patients.\""},
        	{"\"MicroRNA-300 promotes apoptosis and inhibits proliferation, migration, invasion and epithelial-mesenchymal transition via the Wnt/?-catenin signaling pathway by targeting CUL4B in pancreatic cancer ce\""},
        	{"\"MicroRNA-302a functions as a putative tumor suppressor in colon cancer by targeting Akt.\""},
        	{"\"MicroRNA-302a Suppresses Tumor Cell Proliferation by Inhibiting AKT in Prostate Cancer.\""},
        	{"\"MicroRNA 302b-3p/302c-3p/302d-3p inhibits epithelial-mesenchymal transition and promotes apoptosis in human endometrial carcinoma cells.\""},
        	{"\"MiR-30 suppresses lung cancer cell 95D epithelial mesenchymal transition and invasion through targeted regulating Snail.\""},
        	{"\"Downregulation of MiR-30a is Associated with Poor Prognosis in Lung Cancer.\""},
        	{"\"MicroRNA-30d promotes angiogenesis and tumor growth via MYPT1/c-JUN/VEGFA pathway and predicts aggressive outcome in prostate cancer.\""},
        	{"\"Concurrent suppression of integrin alpha5, radixin, and RhoA phenocopies the effects of miR-31 on metastasis.\""},
        	{"\"miR-31 functions as an oncogene in cervical cancer.\""},
        	{"\"Identification of chemoresistance-associated miRNAs in breast cancer.\""},
        	{"\"miR-32 functions as a tumor suppressor and directly targets SOX9 in human non-small cell lung cancer [Retraction].\""},
        	{"\"miR-32 functions as a tumor suppressor and directly targets SOX9 in human non-small cell lung cancer.\""},
        	{"\"microRNA-320a inhibits tumor invasion by targeting neuropilin?1 and is associated with liver metastasis in colorectal cancer.\""},
        	{"\"[Corrigendum] microRNA-320a inhibits tumor invasion by targeting neuropilin 1 and is associated with liver metastasis in colorectal cancer.\""},
        	{"\"[The expression and significance of miRNA-324-3p and WNT2B in nasopharyngeal carcinoma].\""},
        	{"\"The microRNA-325 inhibits hepatocellular carcinoma progression by targeting high mobility group box 1.\""},
        	{"\"MicroRNA-330-3p promotes cell invasion and metastasis in non-small cell lung cancer through GRIA3 by activating MAPK/ERK signaling pathway.\""},
        	{"\"microRNA-338-3p inhibits proliferation, migration, invasion, and EMT in osteosarcoma cells by targeting activator of 90 kDa heat shock protein ATPase homolog 1.\""},
        	{"\"miR-338-5p inhibits cell proliferation, colony formation, migration and cisplatin resistance in esophageal squamous cancer cells by targeting FERMT2.\""},
        	{"\"MiR-338-5p suppresses proliferation, migration, invasion, and promote apoptosis of glioblastoma cells by directly targeting EFEMP1.\""},
        	{"\"Effects of miR-339-5p on invasion and prognosis of hepatocellular carcinoma.\""},
        	{"\"MicroRNA-33a promotes cell proliferation and inhibits apoptosis by targeting PPAR? in human hepatocellular carcinoma.\""},
        	{"\"MicroRNA-340 inhibits invasion and metastasis by downregulating ROCK1 in breast cancer cells.\""},
        	{"\"miR-340 suppresses glioblastoma multiforme.\""},
        	{"\"MiR-340-5p is a potential prognostic indicator of colorectal cancer and modulates ANXA3.\""},
        	{"\"miR-34a expression in human breast cancer is associated with drug resistance.\""},
        	{"\"miR-34a Regulates Expression of the Stathmin-1 Oncoprotein and Prostate Cancer Progression.\""},
        	{"\"The microRNA miR-34a inhibits prostate cancer stem cells and metastasis by directly repressing CD44.\""},
        	{"\"Registered report: the microRNA miR-34a inhibits prostate cancer stem cells and metastasis by directly repressing CD44.\""},
        	{"\"MicroRNA-34a suppresses cell proliferation and metastasis by targeting CD44 in human renal carcinoma cell.\""},
        	{"\"MiR-34b-5p Suppresses Melanoma Differentiation-Associated Gene 5 (MDA5) Signaling Pathway to Promote Avian Leukosis Virus Subgroup J (ALV-J)-Infected Cells Proliferaction and ALV-J Replication.\""},
        	{"\"MiR-361-5p inhibits the mobility of gastric cancer cells through suppressing epithelial-mesenchymal transition via the Wnt/?-catenin pathway.\""},
        	{"\"miR-361-5p inhibits hepatocellular carcinoma cell proliferation and invasion by targeting VEGFA.\""},
        	{"\"Erratum to: Anti-miR-362-3p Inhibits Migration and Invasion of Human Gastric Cancer Cells by Its Target CD82.\""},
        	{"\"Anti-miR-362-3p Inhibits Migration and Invasion of Human Gastric Cancer Cells by Its Target CD82.\""},
        	{"\"MicroRNA-365 inhibits growth, invasion and metastasis of malignant melanoma by targeting NRP1 expression.\""},
        	{"\"miR-367 promotes proliferation and invasion of hepatocellular carcinoma cells by negatively regulating PTEN.\""},
        	{"\"MicroRNA-371-5p targets SOX2 in gastric cancer.\""},
        	{"\"MicroRNA-373 promotes migration and invasion in human esophageal squamous cell carcinoma by inhibiting TIMP3 expression.\""},
        	{"\"Down-regulation of miR-373 increases the radiosensitivity of lung cancer cells by targeting TIMP2.\""},
        	{"\"MiR-375 frequently downregulated in gastric cancer inhibits cell proliferation by targeting JAK2.\""},
        	{"\"MicroRNA-375 inhibits glioma cell proliferation and migration by downregulating RWDD3 in vitro.\""},
        	{"\"Expression levels of microRNA-375 in pancreatic cancer.\""},
        	{"\"MicroRNA-383 expression regulates proliferation, migration, invasion, and apoptosis in human glioma cells.\""},
        	{"\"Pleiotrophin, a target of miR-384, promotes proliferation, metastasis and lipogenesis in HBV-related hepatocellular carcinoma.\""},
        	{"\"MicroRNA-409-3p inhibits osteosarcoma cell migration and invasion by targeting catenin-?1.\""},
        	{"\"Upregulated expression of miR-421 is associated with poor prognosis in non-small-cell lung cancer.\""},
        	{"\"miR-424-5p promotes proliferation of gastric cancer by targeting Smad3 through TGF-? signaling pathway.\""},
        	{"\"microRNA-425-5p is upregulated in human gastric cancer and contributes to invasion and metastasis in vitro and in vivo.\""},
        	{"\"miR-429 mediates tumor growth and metastasis in colorectal cancer.\""},
        	{"\"miR-4295 promotes cell proliferation and invasion in anaplastic thyroid carcinoma via CDKN1A.\""},
        	{"\"MiR-4295 promotes cell growth in bladder cancer by targeting BTG1.\""},
        	{"\"MiR-431 inhibits colorectal cancer cell invasion via repressing CUL4B.\""},
        	{"\"miR-449a promotes liver cancer cell apoptosis by down-regulation of Calpain6 and POU2F1.\""},
        	{"\"Effect of miR-451 on the Biological Behavior of the Esophageal Carcinoma Cell Line EC9706.\""},
        	{"\"MiR-451 as a new tumor marker for gastric cancer.\""},
        	{"\"miR-451a is underexpressed and targets AKT/mTOR pathway in papillary thyroid carcinoma.\""},
        	{"\"Decreased microRNA-452 expression and its prognostic significance in human osteosarcoma.\""},
        	{"\"Extracellular metabolic energetics can promote cancer progression.\""},
        	{"\"Serum miR-483-5p as a potential biomarker to detect hepatocellular carcinoma.\""},
        	{"\"miR-484 suppresses proliferation and epithelial-mesenchymal transition by targeting ZEB1 and SMAD2 in cervical cancer cells.\""},
        	{"\"miRNA-487a Promotes Proliferation and Metastasis in Hepatocellular Carcinoma.\""},
        	{"\"MicroRNA-490-3p inhibits colorectal cancer metastasis by targeting TGF?R1.\""},
        	{"\"Epigenetic silencing of miR-490-3p promotes development of an aggressive colorectal cancer phenotype through activation of the Wnt/?-catenin signaling pathway.\""},
        	{"\"MicroRNA-490-5p inhibits proliferation of bladder cancer by targeting c-Fos.\""},
        	{"\"Upregulation of miR-21 and downregulation of miR-494 may serve as emerging molecular biomarkers for prediagnostic samples of subjects who developed nasopharyngeal carcinoma associates with lymph node\""},
        	{"\"MicroRNA-497 inhibits multiple myeloma growth and increases susceptibility to bortezomib by targeting Bcl-2.\""},
        	{"\"MicroRNA-499a-5p inhibits osteosarcoma cell proliferation and differentiation by targeting protein phosphatase 1D through protein kinase B/glycogen synthase kinase 3? signaling.\""},
        	{"\"MicroRNA-500 sustains nuclear factor-?B activation and induces gastric cancer cell proliferation and resistance to apoptosis.\""}

};
    }

    
    
    public static void writeToCSV(String topic,String abstractText) throws IOException {
    	
    

    	FileWriter csvWriter = new FileWriter("C:\\Users\\unni_\\OneDrive\\Documents\\output\\AbstractList.tsv",true);
    	csvWriter.append(topic);
    	csvWriter.append("\t");
    	csvWriter.append(abstractText);    	
    	csvWriter.append("\n");


    	csvWriter.flush();
    	csvWriter.close();
    	
    }
    
}
