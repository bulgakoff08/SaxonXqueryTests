package com.example.xquery;

import com.saxonica.xqj.SaxonXQDataSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Feature;

import javax.xml.xquery.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Processor {

    public static void main (String... args) throws IOException, XQException {
        XqueryAccessor accessor = new XqueryAccessor("resources");

        XQSequence result = accessor.executeFile("section-transform-1.xq");
        result.writeSequence(System.out, null);

        /* XQSequence result = accessor.executeFile("rename.xq");
        result.writeSequence(System.out, null);

        result = accessor.executeFile("delete.xq");
        result.writeSequence(System.out, null); */

    }

    private static class XqueryAccessor {

        private String HOME;
        private XQConnection connection;

        private XqueryAccessor(String homeDir) throws XQException {
            this.HOME = homeDir;
            Configuration configuration = Configuration.newConfiguration();
            configuration.setConfigurationProperty(Feature.XQUERY_VERSION, "3.1");
            XQDataSource dataSource = new SaxonXQDataSource(configuration);
            this.connection = dataSource.getConnection();
        }

        private XQSequence executeFile(String xQueryFile) throws IOException, XQException {
            return connection.prepareExpression(new FileInputStream(HOME + "/xquery/" + xQueryFile)).executeQuery();
        }

        private XQSequence executeQuery(String xQueryString) throws XQException {
            return connection.prepareExpression(xQueryString).executeQuery();
        }
    }
}