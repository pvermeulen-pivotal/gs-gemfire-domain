package io.pivotal.gemfire.server.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.gemfire.domain.AssociationRules;
import io.pivotal.gemfire.domain.Beacon;
import io.pivotal.gemfire.domain.Category;
import io.pivotal.gemfire.domain.Customer;
import io.pivotal.gemfire.domain.CustomerFavorites;
import io.pivotal.gemfire.domain.Product;
import io.pivotal.gemfire.domain.ProductPromotion;
import io.pivotal.gemfire.domain.Promotion;
import io.pivotal.gemfire.domain.Store;

public class Setup {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ClientCache cache = new ClientCacheFactory().setPdxReadSerialized(false)
				.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.gemfire.domain.*"))
				.addPoolLocator("localhost", 10334).create();
		Region customer = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Customer");
		Region beacon = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Beacon");
		Region store = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Store");
		Region category = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Category");
		Region rules = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("AssociationRules");
		Region customerFavorites = cache.createClientRegionFactory(ClientRegionShortcut.PROXY)
				.create("CustomerFavorites");
		Region product = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Product");
		Region productpromo = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("ProductPromotion");
		Region promotion = cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Promotion");

		createCustomer(customer);
		createStore(store);
		createBeacon(beacon);
		createCategory(category);
		createProduct(product);
		createProductPromotion(productpromo);
		createPromotion(promotion);
		createCustomerFavorties(customerFavorites);
		createAssocRules(rules);
	}

	private static void createCustomer(Region region) {
		Customer cust = new Customer();
		cust.setFirstName("Jeffrey");
		cust.setLastName("Customer");
		cust.setCustomerId(12345678L);
		region.put(cust.getKey(), cust);

		cust = new Customer();
		cust.setFirstName("Nick");
		cust.setLastName("Customer");
		cust.setCustomerId(987654321L);
		region.put(cust.getKey(), cust);
	}

	private static void createStore(Region region) {
		Store store = new Store();
		store.setName("Pivotal Store 1000");
		store.setStoreId(1000);
		region.put(store.getKey(), store);
	}

	private static void createBeacon(Region region) {
		Beacon beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(0L);
		beacon.setMajor(1000);
		beacon.setMinor(0);
		beacon.setCategory(0);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(1L);
		beacon.setMajor(1000);
		beacon.setMinor(1);
		beacon.setCategory(1);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(2L);
		beacon.setMajor(1000);
		beacon.setMinor(2);
		beacon.setCategory(2);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(3L);
		beacon.setMajor(1000);
		beacon.setMinor(3);
		beacon.setCategory(3);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(4L);
		beacon.setMajor(1000);
		beacon.setMinor(4);
		beacon.setCategory(11);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(5L);
		beacon.setMajor(1000);
		beacon.setMinor(5);
		beacon.setCategory(22);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(6L);
		beacon.setMajor(1000);
		beacon.setMinor(6);
		beacon.setCategory(33);
		region.put(beacon.getKey(), beacon);

		beacon = new Beacon();
		beacon.setUuid("ABCDEF0123456789");
		beacon.setId(99L);
		beacon.setMajor(1000);
		beacon.setMinor(99);
		beacon.setCategory(0);
		region.put(beacon.getKey(), beacon);

	}

	private static void createCategory(Region region) {
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Category 1");
		category.setSubCategoryId(1);
		category.setSubCategoryName("Sub Category 1");
		region.put(category.getKey(), category);

		category = new Category();
		category.setCategoryId(2);
		category.setCategoryName("Category 2");
		category.setSubCategoryId(2);
		category.setSubCategoryName("Sub Category 2");
		region.put(category.getKey(), category);

		category = new Category();
		category.setCategoryId(3);
		category.setCategoryName("Category 3");
		category.setSubCategoryId(3);
		category.setSubCategoryName("Sub Category 3");
		region.put(category.getKey(), category);

		category = new Category();
		category.setCategoryId(11);
		category.setCategoryName("Category 11");
		category.setSubCategoryId(11);
		category.setSubCategoryName("Sub Category 11");
		region.put(category.getKey(), category);

		category = new Category();
		category.setCategoryId(22);
		category.setCategoryName("Category 22");
		category.setSubCategoryId(22);
		category.setSubCategoryName("Sub Category 22");
		region.put(category.getKey(), category);

		category = new Category();
		category.setCategoryId(33);
		category.setCategoryName("Category 33");
		category.setSubCategoryId(33);
		category.setSubCategoryName("Sub Category 33");
		region.put(category.getKey(), category);

}

	private static void createProduct(Region region) {
		Product product = new Product();
		product.setCategoryId(1);
		product.setPrice(3.67);
		product.setProductId(1);
		product.setProductName("Bayer Aspirin");
		product.setSubCategoryId(1);
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWCo1zUVwNwIQljB8kq5Zt-aapLzziY2UCEVcBYEJq_svctMbD");
		region.put(product.getKey(), product);

		product = new Product();
		product.setCategoryId(2); //11
		product.setPrice(3.67);
		product.setProductId(2); //11
		product.setProductName("Pampers Disposible Diapers");
		product.setSubCategoryId(2);//11
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHx2bPPu72yCyd9wt_8u_fu5VUHFEKMVLRV4GCELfiQTc6O368Qg");
		region.put(product.getKey(), product);

		product = new Product();
		product.setCategoryId(11);//2
		product.setPrice(3.67);
		product.setProductId(11);//2
		product.setProductName("Jimmy Dean English Muffin");
		product.setSubCategoryId(11);//2
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5jlx6UId3jW_FSB929MlDOCPaMk3UP76Eantpho7vdR1M3P-W");
		region.put(product.getKey(), product);

		product = new Product();
		product.setCategoryId(22);
		product.setPrice(3.67);
		product.setProductId(22);
		product.setProductName("Farmhouse Gold Quart Milk");
		product.setSubCategoryId(22);
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGK73mPhUGe4n9SZY4vdrKXD4Nj2D77Cx2UNrIoYtKbUfks8c3TQ");
		region.put(product.getKey(), product);

		product = new Product();
		product.setCategoryId(3);
		product.setPrice(3.67);
		product.setProductId(3);
		product.setProductName("Digiorno Pizza");
		product.setSubCategoryId(3);
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvwNTkK-8xk3oHM-tFRk20jgqx5piq0qf1DI4gvgoEXgCfEdIz");
		region.put(product.getKey(), product);

		product = new Product();
		product.setCategoryId(33);
		product.setPrice(3.67);
		product.setProductId(33);
		product.setProductName("Green Giant Iceburg Lettuce");
		product.setSubCategoryId(33);
		product.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8cEmgQLd2RQ_p78LURwi9nhgFdEXLU2MoA60j5rhJ3SkE5QKdvg");
		region.put(product.getKey(), product);
	}

	private static void createProductPromotion(Region region) {
		ProductPromotion promo = new ProductPromotion();
		promo.setCategoryId(1);
		promo.setPromotionId(1);
		promo.setSubCategoryId(1);
		promo.setProductId(1);
		region.put(promo.getKey(), promo);

		promo = new ProductPromotion();
		promo.setCategoryId(11);
		promo.setPromotionId(11);
		promo.setSubCategoryId(11);
		promo.setProductId(11);
		region.put(promo.getKey(), promo);

		promo = new ProductPromotion();
		promo.setCategoryId(3);
		promo.setPromotionId(3);
		promo.setSubCategoryId(3);
		promo.setProductId(3);
		region.put(promo.getKey(), promo);
	}

	private static void createPromotion(Region region) {
		Promotion promo = new Promotion();
		promo.setMessage("BOGO Offer on Fat Tire Beer");
		promo.setPromotionId(1);
		promo.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlHfsjqlnrS23ubhbABgmFGZ_S0CJNEWHcTt11r9T7sCuoCrpd5Q");
		region.put(promo.getKey(), promo);

		promo = new Promotion();
		promo.setMessage("Save $1.00 on your favorite antacid");
		promo.setPromotionId(2);
		promo.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeL2LGH5u2Sab40T9jfEBvcaex6atDPqsfRdfraJLFcf8mhO_t");
		region.put(promo.getKey(), promo);

		promo = new Promotion();
		promo.setMessage("Buy two Digiorno pizzas and get the third Digiorno pizza for free");
		promo.setPromotionId(3);
		promo.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvwNTkK-8xk3oHM-tFRk20jgqx5piq0qf1DI4gvgoEXgCfEdIz");
		region.put(promo.getKey(), promo);

		promo = new Promotion();
		promo.setMessage("BOGO Offer on Pringles potato chips");
		promo.setPromotionId(11);
		promo.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDGySW9A17utQiTb5rD9b3UFbSJZdyYnj_g4nz2KBObNDldAIA_w");
		region.put(promo.getKey(), promo);

	}

	private static void createCustomerFavorties(Region region) {
		CustomerFavorites favs= new CustomerFavorites ();
		favs.setCustomerId(987654321L);
		favs.setId(11L);
		favs.setProductId(11L);
		region.put(favs.getKey(), favs);

		favs= new CustomerFavorites ();
		favs.setCustomerId(987654321L);
		favs.setId(2L);
		favs.setProductId(2L);
		region.put(favs.getKey(), favs);

		favs= new CustomerFavorites ();
		favs.setCustomerId(12345678L);
		favs.setId(22L);
		favs.setProductId(22L);
		region.put(favs.getKey(), favs);

		favs= new CustomerFavorites ();
		favs.setCustomerId(987654321L);
		favs.setId(33L);
		favs.setProductId(33L);
		region.put(favs.getKey(), favs);

	}

	private static void createAssocRules(Region region) {
		AssociationRules rules= new AssociationRules ();
		rules.setPreProductId(1L);
		rules.setPostProductId(11L);
		rules.setRuleId(1);
		rules.setConviction(1.5);
		rules.setConfidence(1.5);
		region.put(rules.getKey(), rules);

		rules= new AssociationRules ();
		rules.setPreProductId(2L);
		rules.setPostProductId(22L);
		rules.setRuleId(2);
		rules.setConviction(1.5);
		rules.setConfidence(1.5);
		region.put(rules.getKey(), rules);

		rules= new AssociationRules ();
		rules.setPreProductId(11L);
		rules.setPostProductId(22L);
		rules.setRuleId(3);
		rules.setConviction(1.5);
		rules.setConfidence(1.5);
		region.put(rules.getKey(), rules);

		rules= new AssociationRules ();
		rules.setPreProductId(22L);
		rules.setPostProductId(33L);
		rules.setRuleId(4);
		rules.setConviction(1.5);
		rules.setConfidence(1.5);
		region.put(rules.getKey(), rules);
	
		rules= new AssociationRules ();
		rules.setPreProductId(22L);
		rules.setPostProductId(1L);
		rules.setRuleId(5);
		rules.setConviction(1.5);
		rules.setConfidence(1.8);
		region.put(rules.getKey(), rules);
	
		rules= new AssociationRules ();
		rules.setPreProductId(33L);
		rules.setPostProductId(11L);
		rules.setRuleId(6);
		rules.setConviction(1.5);
		rules.setConfidence(1.5);
		region.put(rules.getKey(), rules);
	}
}
