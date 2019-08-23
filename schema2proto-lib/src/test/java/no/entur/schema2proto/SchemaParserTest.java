package no.entur.schema2proto;

/*-
 * #%L
 * schema2proto-lib
 * %%
 * Copyright (C) 2019 Entur
 * %%
 * Licensed under the EUPL, Version 1.1 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * #L%
 */

import static no.entur.schema2proto.TestHelper.compareExpectedAndGenerated;
import static no.entur.schema2proto.TestHelper.generateProtobuf;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SchemaParserTest {

	private File expectedRootFolder = new File("src/test/resources/expectedproto/basic/default");
	private File generatedRootFolder = new File(".");

	@Test
	public void testAnyTypeElement() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "anytype.proto", generatedRootFolder,
				generateProtobuf("basic/anyType.xsd", "default", "default.proto", false));
	}

	@Test
	public void testNestedTopLevelElement() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "nestedtoplevelelement.proto", generatedRootFolder,
				generateProtobuf("basic/nestedtoplevelelement.xsd", "default", "default.proto", false));
	}

	@Test
	public void testBasicTopLevelEnum() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "toplevelenum.proto", generatedRootFolder,
				generateProtobuf("basic/toplevelenum.xsd", "default", "default.proto", false));
	}

	@Test
	public void testBasicTopLevelComplexType() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "toplevelcomplextype.proto", generatedRootFolder,
				generateProtobuf("basic/toplevelcomplextype.xsd", "default", "default.proto", false));
	}

	@Test
	public void testBasicTopLevelSimpleType() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "toplevelsimpletype.proto", generatedRootFolder,
				generateProtobuf("basic/toplevelsimpletype.xsd", "default", "default.proto", false));
	}

	@Test
	public void testBasicExtensionBase() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "extensionbase.proto", generatedRootFolder,
				generateProtobuf("basic/extensionbase.xsd", "default", "default.proto", false));
	}

	@Test
	public void testBasicExtensionBaseComposition() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "extensionbase_composition.proto", generatedRootFolder,
				generateProtobuf("basic/extensionbase.xsd", null, null, null, true, "default", "default.proto"));
	}

	@Test
	public void testBasicInheritanceToComposition() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "inheritancetocomposition.proto", generatedRootFolder,
				generateProtobuf("basic/inheritancetocomposition.xsd", null, null, null, true, "default", "default.proto"));
	}

	@Test
	public void testBasicExtensionBase2() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "extensionbase2.proto", generatedRootFolder,
				generateProtobuf("basic/extensionbase2.xsd", "default", "default.proto", false));
	}

	@Test
	public void testExtensionBaseDuplicateElements() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "extensionbaseduplicateelements.proto", generatedRootFolder,
				generateProtobuf("basic/extensionbaseduplicateelements.xsd", "default", "default.proto", false));
	}

	@Test
	public void testElementExtensions() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "extendedelement.proto", generatedRootFolder,
				generateProtobuf("basic/extendedelement.xsd", "default", "default.proto", false));
	}

	@Test
	public void testDifferentInnerClassesWithSameName() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "differentinnerclasseswithsamename.proto", generatedRootFolder,
				generateProtobuf("basic/differentinnerclasseswithsamename.xsd", "default", "default.proto", false));
	}

	@Test
	public void testAttributeGroups() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "attributegroups.proto", generatedRootFolder,
				generateProtobuf("basic/attributegroups.xsd", "default", "default.proto", false));
	}

	@Test
	public void testElementRef() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "elementref.proto", generatedRootFolder,
				generateProtobuf("basic/elementref.xsd", "default", "default.proto", false));
	}

	@Test
	public void testSkipEmptyTypeInheritance() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "skipemptytypeinheritance.proto", generatedRootFolder,
				generateProtobuf("basic/skipemptytypeinheritance.xsd", "default", "default.proto", true));
	}

	@Test
	public void testUnboundedChoice() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "unboundedchoices.proto", generatedRootFolder,
				generateProtobuf("basic/unboundedchoices.xsd", "default", "default.proto", false));
	}

	@Test
	public void testUnboundedSequence() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "unboundedsequences.proto", generatedRootFolder,
				generateProtobuf("basic/unboundedsequences.xsd", "default", "default.proto", false));
	}

	@Test
	public void testList() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "list.proto", generatedRootFolder,
				generateProtobuf("basic/list.xsd", "default", "default.proto", false));
	}

	@Test
	public void testUnion() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "union.proto", generatedRootFolder,
				generateProtobuf("basic/union.xsd", "default", "default.proto", false));
	}

	// Disabled for now @Test
	public void testValidationRules() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "validationrules.proto", generatedRootFolder,
				generateProtobuf("basic/validationrules.xsd", "default", "default.proto", false));
	}

	@Test
	public void testRestrictionBase() throws IOException {
		compareExpectedAndGenerated(expectedRootFolder, "restrictionbaseduplicateelements.proto", generatedRootFolder,
				generateProtobuf("basic/restrictionbaseduplicateelements.xsd", "default", "default.proto", false));
	}

}
