
import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"LFakeRepository;", "", "networkAPI", "LFakeNetworkAPI;", "(LFakeNetworkAPI;)V", "getNetworkAPI", "()LFakeNetworkAPI;", "getModel", "LFakeModel;", "DaggerBomber"})
public final class FakeRepository {
    @org.jetbrains.annotations.NotNull()
    private final FakeNetworkAPI networkAPI = null;
    
    @org.jetbrains.annotations.NotNull()
    public final FakeModel getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final FakeNetworkAPI getNetworkAPI() {
        return null;
    }
    
    @javax.inject.Inject()
    public FakeRepository(@org.jetbrains.annotations.NotNull()
    FakeNetworkAPI networkAPI) {
        super();
    }
}