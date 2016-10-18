package org.telegram.tl.L57.messages;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class Stickers extends TLStickers {

    public static final int ID = 0x8a8ecd32;

    public String hash;
    public TLVector<TLDocument> stickers;

    public Stickers() {
        this.stickers = new TLVector<>();
    }

    public Stickers(String hash, TLVector<TLDocument> stickers) {
        this.hash = hash;
        this.stickers = stickers;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        hash = buffer.readString();
        stickers = (TLVector<TLDocument>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeString(hash);
        buff.writeTLObject(stickers);
    }


    public int getConstructor() {
        return ID;
    }
}