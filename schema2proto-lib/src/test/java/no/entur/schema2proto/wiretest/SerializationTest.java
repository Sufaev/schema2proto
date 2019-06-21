package no.entur.schema2proto.wiretest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;
import com.squareup.wire.schema.EnumConstant;
import com.squareup.wire.schema.EnumType;
import com.squareup.wire.schema.Extensions;
import com.squareup.wire.schema.Field;
import com.squareup.wire.schema.Location;
import com.squareup.wire.schema.MessageType;
import com.squareup.wire.schema.OneOf;
import com.squareup.wire.schema.Options;
import com.squareup.wire.schema.ProtoFile;
import com.squareup.wire.schema.ProtoFile.Syntax;
import com.squareup.wire.schema.ProtoType;
import com.squareup.wire.schema.Reserved;
import com.squareup.wire.schema.Type;
import com.squareup.wire.schema.internal.parser.OptionElement;

public class SerializationTest {
	@Test
	public void testBuildProtoFile() {

		ProtoFile f = new ProtoFile(Syntax.PROTO_3, "default");

		List<EnumConstant> values = new ArrayList<EnumConstant>();
		List<OptionElement> elements = new ArrayList<>();
		Options constantOptions = new Options(ProtoType.BOOL, elements);

		Location valueLocation = new Location("base", "file", 1, 2);
		values.add(new EnumConstant(valueLocation, "VAL1", 1, "doc", constantOptions));
		Options options = new Options(ProtoType.BOOL, new ArrayList<>());
		f.types().add(new EnumType(ProtoType.INT32, valueLocation, "doc", "Name", values, options));

		Location messagLocation = new Location("base", "path", 1, 1);
		ImmutableList<Field> declaredFields = ImmutableList.copyOf(new ArrayList<>());
		List<Field> extensionFields = new ArrayList<>();

		ImmutableList<OneOf> oneOfs = ImmutableList.copyOf(new ArrayList<>());

		ImmutableList<Type> nestedTypes = ImmutableList.copyOf(new ArrayList<>());

		List<Extensions> extensionsList = new ArrayList<>();

		List<Reserved> reserveds = new ArrayList<>();

		List<OptionElement> messageOptionElements = new ArrayList<>();
		Options messageOptions = new Options(ProtoType.BOOL, messageOptionElements);
		MessageType message = new MessageType(ProtoType.BOOL, messagLocation, "doc", "messagename", declaredFields, extensionFields, oneOfs, nestedTypes,
				extensionsList, reserveds, messageOptions);
		f.types().add(message);

		String schema = f.toSchema();
		assertNotNull(schema);
	}
}