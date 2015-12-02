package store.packages.resource;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import store.packages.model.Product;
import store.packages.service.ProductService;

@Path("products")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProductResource {

    ProductService productService;

    public ProductResource(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("productService") == null) {
            productService = new ProductService();
            session.setAttribute("productService", productService);
        } else {
            productService = (ProductService) session.getAttribute("productService");
        }
    }

    @GET
    public List<Product> getProductList() {
        return productService.getProducts();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") int id) {
        return productService.getProduct(id);
    }
}
