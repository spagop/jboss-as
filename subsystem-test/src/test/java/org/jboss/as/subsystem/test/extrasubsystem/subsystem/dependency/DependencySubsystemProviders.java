package org.jboss.as.subsystem.test.extrasubsystem.subsystem.dependency;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.DESCRIPTION;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.HEAD_COMMENT_ALLOWED;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.NAMESPACE;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.TAIL_COMMENT_ALLOWED;

import java.util.Locale;

import org.jboss.as.controller.descriptions.DescriptionProvider;
import org.jboss.dmr.ModelNode;

/**
 * Contains the description providers. The description providers are what print out the
 * information when you execute the {@code read-resource-description} operation.
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
class DependencySubsystemProviders {

    /**
     * Used to create the description of the subsystem
     */
    public static DescriptionProvider SUBSYSTEM = new DescriptionProvider() {
        public ModelNode getModelDescription(Locale locale) {
            //The locale is passed in so you can internationalize the strings used in the descriptions

            final ModelNode subsystem = new ModelNode();
            subsystem.get(DESCRIPTION).set("This is my subsystem");
            subsystem.get(HEAD_COMMENT_ALLOWED).set(true);
            subsystem.get(TAIL_COMMENT_ALLOWED).set(true);
            subsystem.get(NAMESPACE).set(DependencySubsystemExtension.NAMESPACE);

            return subsystem;
        }
    };

    /**
     * Used to create the description of the subsystem add method
     */
    public static DescriptionProvider SUBSYSTEM_ADD = new DescriptionProvider() {
        public ModelNode getModelDescription(Locale locale) {
            //The locale is passed in so you can internationalize the strings used in the descriptions

            final ModelNode subsystem = new ModelNode();
            subsystem.get(DESCRIPTION).set("Adds my subsystem");

            return subsystem;
        }
    };

}
