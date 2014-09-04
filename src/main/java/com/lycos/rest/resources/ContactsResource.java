package com.lycos.rest.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lycos.rest.bean.Address;
import com.lycos.rest.bean.Contact;
import com.lycos.rest.storage.ContactStore;

@Path("/contacts")
public class ContactsResource {
    private static Logger log = LoggerFactory.getLogger(ContactsResource.class);

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Contact> getContacts() {
        log.info("method getContacts() begin.");
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll(ContactStore.getStore().values());
        log.info("method getContacts() end.");
        return contacts;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        log.info("method getCount() begin.");
        int count = ContactStore.getStore().size();
        log.info("method getCount() end.");
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newContact(@FormParam("id") String id, @FormParam("name") String name,
            @Context HttpServletResponse servletResponse) throws IOException {
        log.info("method newContact() begin.");
        Contact c = new Contact(id, name, new ArrayList<Address>());
        ContactStore.getStore().put(id, c);

        URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
        Response.created(uri).build();
        log.info("method newContact() end.");
        servletResponse.sendRedirect("../pages/new_contact.html");
    }

    @Path("{contact}")
    public ContactResource getContact(@PathParam("contact") String contact) {
        log.info("method getContact() begin.");
        return new ContactResource(uriInfo, request, contact);
    }

}
