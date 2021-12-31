# 기존 buildSrc 폴더 삭제
rm -rf ./buildSrc

# 최신 상태 buildSrc 클론
git clone https://github.com/keelim/buildSrc

# buildSrc 만 빌드
./gradlew --refresh-dependencies